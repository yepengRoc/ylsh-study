### 两种多线程实现方式的对比

看一下Thread类的API：
public
class Thread implements Runnable {
    /* Make sure registerNatives is 


其实Thread类也是实现的Runnable接口。两种实现方式对比的关键就在于extends和implements的对比，当然是后者好。因为第一，继承只能单继承，实现可以多实现；第二，实现的方式对比继承的方式，也有利于减小程序之间的耦合。

因此，多线程的实现几乎都是使用的Runnable接口的方式。

### 线程状态

> 虚拟机中的线程状态有六种，定义在Thread.State中：

1、新建状态NEW

new了但是没有启动的线程的状态。比如"Thread t = new Thread()"，t就是一个处于NEW状态的线程

2、可运行状态RUNNABLE

new出来线程，调用start()方法即处于RUNNABLE状态了。处于RUNNABLE状态的线程可能正在Java虚拟机中运行，也可能正在等待处理器的资源，因为一个线程必须获得CPU的资源后，才可以运行其run()方法中的内容，否则排队等待

3、阻塞BLOCKED

如果某一线程正在等待监视器锁，以便进入一个同步的块/方法，那么这个线程的状态就是阻塞BLOCKED

4、等待WAITING

某一线程因为调用不带超时的Object的wait()方法、不带超时的Thread的join()方法、LockSupport的park()方法，就会处于等待WAITING状态

5、超时等待TIMED_WAITING

某一线程因为调用带有指定正等待时间的Object的wait()方法、Thread的join()方法、Thread的sleep()方法、LockSupport的parkNanos()方法、LockSupport的parkUntil()方法，就会处于超时等待TIMED_WAITING状态

6、终止状态TERMINATED

线程调用终止或者run()方法执行结束后，线程即处于终止状态。处于终止状态的线程不具备继续运行的能力

### interrupt解释

> interrupt()方法的作用实际上是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞状态。换句话说，没有被阻塞的线程，调用interrupt()方法是不起作用的。

### join解释
join()方法会使调用join()方法的线程（也就是mt线程）所在的线程（也就是main线程）无限阻塞，直到调用join()方法的线程销毁为止，此例中main线程就会无限期阻塞直到mt的run()方法执行完毕。

join()方法的一个重点是要区分出和sleep()方法的区别。join(2000)也是可以的，表示调用join()方法所在的线程最多等待2000ms，两者的区别在于：

sleep(2000)不释放锁，join(2000)释放锁，因为join()方法内部使用的是wait()，因此会释放锁。看一下join(2000)的源码就知道了，join()其实和join(2000)一样，无非是join(0)而已：
 1	public final synchronized void join(long millis) 
 2     throws InterruptedException {
 3     long base = System.currentTimeMillis();
 4     long now = 0;
 5 
 6     if (millis < 0) {
 7             throw new IllegalArgumentException("timeout value is negative");
 8     }
 9 
10     if (millis == 0) {
11         while (isAlive()) {
12         wait(0);
13         }
14     } else {
15         while (isAlive()) {
16         long delay = millis - now;
17         if (delay <= 0) {
18             break;
19         }
20         wait(delay);
21         now = System.currentTimeMillis() - base;
22         }
23     }
24     }