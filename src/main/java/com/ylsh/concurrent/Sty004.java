package com.ylsh.concurrent;

/**
 *
 * 偏向锁
 * 轻量级锁
 * 重量级锁
 * 自旋锁
 *
 * javap -v 或java -verbose  Sty004.class查看字节码
 *
 * 当使用synchronied修饰代码块时，虚拟机在在字节码层面上通过moitorenter和monitorexit指令实现锁的释放和获取
 * 线程进入到monitorenter指令后，线程持有monitor对象，推出monitorexit指令后，线程释放monitor对象
 *
 * synchronized修饰非静态方法时，没有monitorenter和monitorexit，只有一个ACC_SYNCHRONIZED表示，当方法被调用时，调用
 * 指令会检查该方法释放拥有ACC_SYNCHRONIZED，如果有的化，会先持有方法所在对象的monitor对象，然后再去执行方法体，
 * 逻辑执行期间，其它任何线程均无法再获取这个monitor对象，逻辑执行结束，释放monitor对象
 *
 * synchronized修饰静态方法时。ACC_SYNCHRONIZED 和ACC_STATIC，获取的是静态方法所在对象的Class对象的monitor对象。
 *
 *
 *      JVM中同步是基于进入与退出监视器对象（管程对象）（Monitor）来实现的，每个对象实例都会有一个monitor对象，monitor对象会
 * 和java对象一起创建并销毁，monitor对象是由c++来实现的。
 *      当多个线程同时访问同一段同步代码时，这些线程会被放到一个EntryList集合中，处于阻塞状态的线程都会被放到改列表中。
 * 接下来，当线程获取到对象的Monitor时，monitor是依赖于操作系统底层的mutex lock来实现互斥的，线程获取mutex成功，则会持有该
 * mutex,这时其它线程就无法再获取到该mutex.
 *      如果线程调用来wait方法，那么该线程就会释放掉所持有的mutex,并且线程会进入到WaitSet集合（等待集合）中，等待下一次被其它
 * 线程调用notify/notifyAll唤醒，如果当前线程顺利执行完方法，呢么它也会释放掉所持有的mutex.
 *
 * 总结：同步锁在这种实现方式中，因为monitor是依赖于底层的操作系统实现，这样就存在用户态和内核态之间的切换，所以会增加性能开销。
 * 通过对象互斥锁的概念来保证数据操作的完成性。每个对象都对应于一个可称为互斥锁的标记，这个标记用于保证在任何时刻，只能有一个线程访问
 * 该对象。
 *  那些处于EntryList与WaitSet中的线程均处于阻塞状态，阻塞操作是由操作系统完成的，在linux下是通过pthread_mutex_lock函数实现的。
 * 线程被阻塞后便会进入到内核调度状态，这回导致系统在用户态与内核态之间来回切换，严重影响锁的性能。
 *  解决上述问题的办法便是自旋（spin）.其原理是：当发生monitor的争用时，若Owner能够在很短的事件内释放锁，则那些正在争用的线程
 * 就可以稍微等待一下（即所谓的自旋），在Owner线程释放锁之后，争用线程可能会立即获取到锁，从而避免了系统阻塞。不过，当Owner运行的
 * 时间超过了临界值后，争用线程自旋一段时间后依然无法获取到锁，这时争用的线程会停止自旋而进入到阻塞状态。所以总体的思想是：先自旋，
 * 不成功再进行阻塞，尽量降低阻塞的可能性，这对呢些执行时间很短的代码块来说有极大的性能提升。显然，自旋在多处理器（多核心）上才有意义。
 *
 * 互斥的属性：
 * 1 PTHREAD_MUTEX_TIMED_NP:这时缺省值，也就是普通锁。当一个线程加锁后，其余请求锁的线程会形成一个等待队列，并且在解锁后按照
 * 优先级获取到锁，这种策略可以确保资源分配的公平性。
 * 2 PTHEAD_MUTEX_RECURSIVE_NP:嵌套锁。允许一个线程对同一个锁成功获取多次，并通过unlock解锁，如果不同的线程请求，则在加锁
 * 线程解锁时从新进行竞争。
 * 3 PTHREAED_MUTEX_ERRORCHECK_NP:检错锁。如果一个线程请求同一个锁，则返回EDEADLKK，否则与
 *PTHREAD_MUTEX_TIMED_NP动作相同，这样就保证了当不允许多次加锁时不会出现最简单情况下的死锁。
 * 4 PTHREAD_MUTEX_ADAPTIVR_NP:适应锁。动作最简单的锁类型，仅仅等待解锁后从新竞争。
 *
 * 在jdk1.5之前，只能通过synchronied实现线程同步；底层的原子行为也是通过synchronized实现的；synchronized关键字是jvm实现的
 * 一种内置锁，锁的获取和释放由jvm隐式实现的。
 *
 * 1.5引入了lock锁，基于java实现，锁的获取与实现由java代码去实现；syn基于底层操作系统的mutex lock实现，锁的获取与释放都会
 * 带来用户态和内核态之间的切换，这种切换会极大增加系统的负担；
 * 并发达，锁竞争激烈，synchronized的性能会差些。
 * jdk1.6开始，syn进行了优化，偏向锁  轻量级锁 重量级锁，以减少线程在用户态和内核态的切换。锁的优化通过java对象头中的一些标志位
 * 来去实现的。
 *
 * jdk1.6开始，对象实例在堆中分为三部分：对象头  实例数据和对齐填充
 * 对象头主要由3部分组成
 * 1 mark word
 * 2指向类的指针
 * 3数组长度
 *
 * 其中mark word (它记录了对象，锁及垃圾回收相关的信息，在64位的jvm中，其长度也是64bit)的信息baokuo0了如下组成部分：
 * 1无锁标记
 * 2偏向锁标记
 * 3轻量级锁标记
 * 4重量级锁标记
 * 5GC标记
 *
 * syn中锁的升级主要通过mark word中的锁标识位于是否是否偏向锁标志位来达成的；syn锁先从偏向锁开始，随着竞争升级位轻量级锁，重量级锁
 *
 * 默认锁会经历这个阶段：
 * 无锁 -》 偏向锁-》轻量级锁-》重量级锁
 * 偏向锁：
 * 针对一个线程来说，它的主要作用就是优化同一个线程多次获取一个锁的情况；如果一个syn方法被一个线程访问，那么这个方法所在的对象
 * 就会在其Mark Word中将偏向锁进行标记，同时还会有一个字段来存储该线程的ID;当这个线程再次访问同一个syn方法时，他会检查
 * 这个对象的Mark Word的偏向锁标记以及是否指向了其线程的ID,如果是的话，那么该线程就无须再去进入管理（Monitor）,而是字节进入到
 * 该方法体中。
 *
 * 如果另一个线程访问这个syn方法，那么实际情况会如何？
 * 偏向锁会被取消。
 *
 * 轻量级锁：
 * 若第一个线程已经获取到了当前对象的锁，这时第二个线程又开始尝试争抢该对象的锁，由于该对象的锁已经被第一个线程获取到，
 * 因此它是偏向锁，而第二个线程在争抢时，会发现该对象头中的Mark Word已经是偏向锁，但里面存储的线程ID并不是自己（是第一个线程）
 * ，那么他会进行CAS,从而获取锁，这里面存在两种情况：
 * 1 获取锁成功，那么他会直接将Mark Word中的线程ID由第一个线程变成自己（偏向锁标记位保持不变），这样该对象依然会保持偏向锁的状态。
 * 2 获取锁失败，则表示这是可能有多个线程同时在尝试争抢该对象的锁，那么这是偏向锁就会进行升级，升级为轻量级锁
 *
 * 自旋锁：
 * 若自旋锁（依然无法获取到锁），那么锁就会转化为重量级锁，在这种情况下，无法获取到锁的线程就会进入到Monitor(即内核状态)
 * 自旋UI大的一个特点就是避免了线程从用户态进入到内核态
 *
 * 重量级锁：
 * 线程最终从用户态进入到了内核态
 *
 *
 *
 *
 */
public class Sty004 {

    private Object object = new Object();

    /**
     * 一个monitorenter 两个monitorexit
     */
    public void method(){
        synchronized (object){
            System.out.println("hello world");
        }
    }

    public synchronized void method2(){

    }

    public synchronized static void method3(){

    }

    /**
     * 程序只有一个推出路径，。这里只有一个monitorenter和一个monitorexit
     */
    public void method4(){
        synchronized (object){
            System.out.println("hello world");
            throw new RuntimeException("");

        }
    }
}
