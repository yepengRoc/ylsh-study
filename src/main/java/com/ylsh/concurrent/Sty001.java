package com.ylsh.concurrent;


/**
 * wait会释放对象持有的锁，sleep不会
 *
 * wait和notify notifyAll:
 * 1 当调用wait时，首先需要确保调用类wait方法的线程已经持有类对象的锁
 * 2当调用wait后，该线程就会释放到这个对象的锁，然后进入到等待状态（wait set）
 * 3当调用wait后进入到等待状态时，他就可以等待其它线程调用相同的对象的notify或notifyAll方法来使自己被唤醒
 * 4一旦线程被其它线程唤醒，该线程就会与其它先后从呢哥哥一同开始竞争这个对象的锁（公平竞争）；只有当该线程获取到类这个对象的
 * 锁后，线程才会继续往下执行。
 * 5调用wait方法的代码片段需要放在一个synchronized块或synchronized方法中，这样才可以确保线程在调用wait方法前已经获取
 * 到类对象的锁，。
 * 6当调用对象的notify方法时，它会随机唤醒该对象等待集合（wait set）中任意一个线程，当某个线程被唤醒后，它就会与其它线程
 * 一同竞争对象的锁
 * 7当调用对象的notifyAll方法时，他会唤醒该对象等待集合（wait set）中所有线程，这些线程被唤醒后，又会开始竞争对象的锁。
 * 8在某一个时刻，只有唯一的线程可以拥有对象的锁
 */
public class Sty001 {

    public static void main(String[] args) throws Exception{
        Object object = new Object();

        synchronized (object){
            object.wait();
        }
    }
}
