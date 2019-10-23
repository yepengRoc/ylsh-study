# 学习地址
http://cmsblogs.com/?p=2122


提供一种阻塞锁和同步实现的框架，底层依赖于一个先进先出的等待队列

通过一个原子状态的变化，来实现大部分同步
定义的子类，来控制原子状态的变化，以及那种状态代表什么意思

 Provides a framework for implementing blocking locks and related
 synchronizers (semaphores, events, etc) that rely on
 first-in-first-out (FIFO) wait queues.  This class is designed to
 be a useful basis for most kinds of synchronizers that rely on a
 single atomic {@code int} value to represent state. Subclasses
 must define the protected methods that change this state, and which
 define what that state means in terms of this object being acquired
 or released. 
 //基于这些，其它方法可以实现 排队和阻塞机制
  Given these, the other methods in this class carry out all queuing and blocking mechanics.
  Subclasses can maintain
 other state fields, but only the atomically updated {@code int}
 value manipulated using methods {@link #getState}, {@link
 #setState} and {@link #compareAndSetState} is tracked with respect
 to synchronization.
 通过state状态的变化来跟踪同步状态
 
 
 <p>Subclasses should be defined as non-public internal（非直接公开的） helper（辅助）
 classes that are used to implement the synchronization properties
 of their enclosing class. //封闭类
  Class
 {@code AbstractQueuedSynchronizer} does not implement any
 synchronization interface.  Instead it defines methods such as
 {@link #acquireInterruptibly} that can be invoked as
 appropriate by concrete locks and related synchronizers to
 implement their public methods.
 共享模式当有一个线程获取成功后，其它线程就会获取事变
 <p>This class supports either or both a default exclusive
 mode and a shared mode. When acquired in exclusive mode,
 attempted acquires by other threads cannot succeed. Shared mode
 acquires by multiple threads may (but need not) succeed. This class
 does not &quot;understand&quot; these differences except in the
 mechanical sense that when a shared mode acquire succeeds, the next
 waiting thread (if one exists) must also determine whether it can
 acquire as well. Threads waiting in the different modes share the
 same FIFO queue. Usually, implementation subclasses support only
 one of these modes, but both can come into play for example in a
 {@link ReadWriteLock}. Subclasses that support only exclusive or
 only shared modes need not define the methods supporting the unused mode.
 
 <p>This class defines a nested {@link ConditionObject} class that
 can be used as a {@link Condition} implementation by subclasses
 supporting exclusive mode for which method {@link
 #isHeldExclusively} reports whether synchronization is exclusively
 held with respect to the current thread, method {@link #release}
 invoked with the current {@link #getState} value fully releases
 this object, and {@link #acquire}, given this saved state value,
 eventually restores this object to its previous acquired state.  No
 {@code AbstractQueuedSynchronizer} method otherwise creates such a
 condition, so if this constraint cannot be met, do not use it.  The
 behavior of {@link ConditionObject} depends of course on the
 semantics of its synchronizer implementation.
 
 <p>This class provides inspection, instrumentation, and monitoring
 methods for the internal queue, as well as similar methods for
 condition objects. These can be exported as desired into classes
 using an {@code AbstractQueuedSynchronizer} for their
 synchronization mechanics.
 
 <p>Serialization of this class stores only the underlying atomic
 integer maintaining state, so deserialized objects have empty
 thread queues. Typical subclasses requiring serializability will
 define a {@code readObject} method that restores this to a known
 initial state upon deserialization.
 
 <h3>Usage</h3>
 
 使用此类作为同步，需要重写以下方法。获取原子状态通过getState，设置原子状态通过setState 或者compareAndSetState
 <p>To use this class as the basis of a synchronizer, redefine the
 following methods, as applicable, by inspecting and/or modifying
 the synchronization state using {@link #getState}, {@link
 #setState} and/or {@link #compareAndSetState}:
 
 <ul>
 <li> {@link #tryAcquire}
 <li> {@link #tryRelease}
 <li> {@link #tryAcquireShared}
 <li> {@link #tryReleaseShared}
 <li> {@link #isHeldExclusively}
 </ul>
 
 Each of these methods by default throws {@link
 UnsupportedOperationException}.  Implementations of these methods
 must be internally thread-safe, and should in general be short and// 同步方法的实现应是线程安全的，执行时间短的和不阻塞
 not block. Defining these methods is the <em>only</em> supported
 means of using this class. All other methods are declared
 {@code final} because they cannot be independently varied.
 
 <p>You may also find the inherited methods from {@link
 AbstractOwnableSynchronizer} useful to keep track of the thread
 owning an exclusive synchronizer.  You are encouraged to use them
 this enables monitoring and diagnostic tools to assist users in
 determining which threads hold locks.
 
 <p>Even though this class is based on an internal FIFO queue, it
 does not automatically enforce FIFO acquisition policies.  The core
 of exclusive synchronization takes the form:
 
 <pre>
 Acquire:
     while (!tryAcquire(arg)) {
        <em>enqueue thread if it is not already queued</em>;
        <em>possibly block current thread</em>;
     }
 
 Release:
     if (tryRelease(arg))
        <em>unblock the first queued thread</em>;
 </pre>
 
 (Shared mode is similar but may involve cascading signals.)
 
 <p id="barging">Because checks in acquire are invoked before
 enqueuing, a newly acquiring thread may <em>barge</em> ahead of
 others that are blocked and queued.  However, you can, if desired,
 define {@code tryAcquire} and/or {@code tryAcquireShared} to
 disable barging by internally invoking one or more of the inspection
 methods, thereby（从而） providing a <em>fair</em> FIFO acquisition order.
 In particular, most fair synchronizers can define {@code tryAcquire}
 to return {@code false} if {@link #hasQueuedPredecessors} (a method
 specifically designed to be used by fair synchronizers) returns
 {@code true}.  Other variations are possible.
 
 <p>Throughput and scalability（可扩展） are generally highest for the
 default barging (also known as <em>greedy</em>,
 <em>renouncement</em>, and <em>convoy-avoidance</em>) strategy.
 While this is not guaranteed to be fair or starvation-free, earlier
 queued threads are allowed to recontend before later queued
 threads, and each recontention has an unbiased chance to succeed
 against incoming threads.  Also, while acquires do not
 &quot;spin&quot; in the usual sense, they may perform multiple
 invocations of {@code tryAcquire} interspersed with other
 computations before blocking.  This gives most of the benefits of
 spins when exclusive synchronization is only briefly held, without
 most of the liabilities when it isn't. If so desired, you can
 augment this by preceding calls to acquire methods with
 "fast-path" checks, possibly prechecking {@link #hasContended}
 and/or {@link #hasQueuedThreads} to only do so if the synchronizer
 is likely not to be contended.
 
 <p>This class provides an efficient and scalable basis for
 synchronization in part by specializing its range of use to
 synchronizers that can rely on {@code int} state, acquire, and
 release parameters, and an internal FIFO wait queue. When this does
 not suffice, you can build synchronizers from a lower level using
 {@link java.util.concurrent.atomic atomic} classes, your own custom
 {@link java.util.Queue} classes, and {@link LockSupport} blocking
 support.
 
 <h3>Usage Examples</h3>
 
 <p>Here is a non-reentrant mutual exclusion lock class that uses
 the value zero to represent the unlocked state, and one to
 represent the locked state. While a non-reentrant lock
 does not strictly require recording of the current owner
 thread, this class does so anyway to make usage easier to monitor.
 It also supports conditions and exposes
 one of the instrumentation methods:
 
  <pre> {@code
 class Mutex implements Lock, java.io.Serializable {
 
   // Our internal helper class
   private static class Sync extends AbstractQueuedSynchronizer {
     // Reports whether in locked state
     protected boolean isHeldExclusively() {
       return getState() == 1;
     }
 
     // Acquires the lock if state is zero
     public boolean tryAcquire(int acquires) {
       assert acquires == 1; // Otherwise unused
       if (compareAndSetState(0, 1)) {
         setExclusiveOwnerThread(Thread.currentThread());
         return true;
       }
       return false;
     }
 
     // Releases the lock by setting state to zero
     protected boolean tryRelease(int releases) {
       assert releases == 1; // Otherwise unused
       if (getState() == 0) throw new IllegalMonitorStateException();
       setExclusiveOwnerThread(null);
       setState(0);
       return true;
     }
 
     // Provides a Condition
     Condition newCondition() { return new ConditionObject(); }
 
     // Deserializes properly
     private void readObject(ObjectInputStream s)
         throws IOException, ClassNotFoundException {
       s.defaultReadObject();
       setState(0); // reset to unlocked state
     }
   }
 
   // The sync object does all the hard work. We just forward to it.
   private final Sync sync = new Sync();
 
   public void lock()                { sync.acquire(1); }
   public boolean tryLock()          { return sync.tryAcquire(1); }
   public void unlock()              { sync.release(1); }
   public Condition newCondition()   { return sync.newCondition(); }
   public boolean isLocked()         { return sync.isHeldExclusively(); }
   public boolean hasQueuedThreads() { return sync.hasQueuedThreads(); }
   public void lockInterruptibly() throws InterruptedException {
     sync.acquireInterruptibly(1);
   }
   public boolean tryLock(long timeout, TimeUnit unit)
       throws InterruptedException {
     return sync.tryAcquireNanos(1, unit.toNanos(timeout));
   }
 }}</pre>
 
 <p>Here is a latch class that is like a
 {@link java.util.concurrent.CountDownLatch CountDownLatch}
 except that it only requires a single {@code signal} to
 fire. Because a latch is non-exclusive, it uses the {@code shared}
 acquire and release methods.
 
  <pre> {@code
 class BooleanLatch {
 
   private static class Sync extends AbstractQueuedSynchronizer {
     boolean isSignalled() { return getState() != 0; }
 
     protected int tryAcquireShared(int ignore) {
       return isSignalled() ? 1 : -1;
     }
 
     protected boolean tryReleaseShared(int ignore) {
       setState(1);
       return true;
     }
   }
 
   private final Sync sync = new Sync();
   public boolean isSignalled() { return sync.isSignalled(); }
   public void signal()         { sync.releaseShared(1); }
   public void await() throws InterruptedException {
     sync.acquireSharedInterruptibly(1);
   }
 }}</pre>
 







 
 Wait queue node class.
 
 <p>The wait queue is a variant of a "CLH" (Craig, Landin, and
 Hagersten) lock queue. CLH locks are normally used for
 spinlocks.  We instead use them for blocking synchronizers, but
 use the same basic tactic of holding some of the control
 information about a thread in the predecessor of its node.  A
 "status" field in each node keeps track of whether a thread
 should block.  A node is signalled when its predecessor
 releases.  Each node of the queue otherwise serves as a
 specific-notification-style monitor holding a single waiting
 thread. The status field does NOT control whether threads are
 granted locks etc though.  A thread may try to acquire if it is
 first in the queue. But being first does not guarantee success;
 it only gives the right to contend.  So the currently released
 contender thread may need to rewait.
 //入队是从头部。出队
 <p>To enqueue into a CLH lock, you atomically splice it in as new
 tail. To dequeue, you just set the head field.
 <pre>
      +------+  prev +-----+       +-----+
 head |      | <---- |     | <---- |     |  tail
      +------+       +-----+       +-----+
 </pre>
 
 <p>Insertion into a CLH queue requires only a single atomic
 operation on "tail", so there is a simple atomic point of
 demarcation from unqueued to queued. Similarly, dequeuing
 involves only updating the "head". However, it takes a bit
 more work for nodes to determine who their successors are,
 in part to deal with possible cancellation due to timeouts
 and interrupts. //为了 处理可能的取消和中断
 
 <p>The "prev" links (not used in original CLH locks), are mainly
 needed to handle cancellation. If a node is cancelled, its
 successor（后继） is (normally) relinked to a non-cancelled
 predecessor. For explanation of similar mechanics in the case
 of spin locks, see the papers by Scott and Scherer at
 http://www.cs.rochester.edu/u/scott/synchronization/
 
 <p>We also use "next" links to implement blocking mechanics.
 The thread id for each node is kept in its own node, so a
 predecessor signals the next node to wake up by traversing
 next link to determine which thread it is.  Determination of
 successor must avoid races with newly queued nodes to set
 the "next" fields of their predecessors.  This is solved
 when necessary by checking backwards from the atomically
 updated "tail" when a node's successor appears to be null.
 (Or, said differently, the next-links are an optimization
 so that we don't usually need a backward scan.)
 
 <p>Cancellation introduces some conservatism to the basic
 algorithms.  Since we must poll for cancellation of other
 nodes, we can miss noticing whether a cancelled node is
 ahead or behind us. This is dealt with by always unparking
 successors upon cancellation, allowing them to stabilize on
 a new predecessor, unless we can identify an uncancelled
 predecessor who will carry this responsibility.
 
 <p>CLH queues need a dummy header node to get started. But
 we don't create them on construction, because it would be wasted
 effort if there is never contention. Instead, the node
 is constructed and head and tail pointers are set upon first
 contention.
 
 <p>Threads waiting on Conditions use the same nodes, but
 use an additional link. Conditions only need to link nodes
 in simple (non-concurrent) linked queues because they are
 only accessed when exclusively held.  Upon await, a node is
 inserted into a condition queue.  Upon signal, the node is
 transferred to the main queue.  A special value of status
 field is used to mark which queue a node is on.
 