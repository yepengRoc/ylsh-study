package com.ylsh.study.thread.concurrent;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSStudy {
    public static void main(String[] args) {
      /*  AbstractQueuedSynchronizer aqs = null;
        AbstractQueuedLongSynchronizer asqLong = null;

        Lock lock = new ReentrantLock();

        lock.lock();
        lock.unlock();*/

        Thread thread = new Thread(){
            @Override
            public void run() {
                Thread.interrupted();
                try {
//                    System.out.println(Thread.interrupted());
                    Thread.sleep(5);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        thread.isInterrupted();
        System.out.println("thread.isInterrupted() :" + thread.isInterrupted());
        thread.interrupt();
        System.out.println("thread.isInterrupted() :" + thread.isInterrupted());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }{

        }
        System.out.println("thread.isInterrupted() :" + thread.isInterrupted());


    }

}
