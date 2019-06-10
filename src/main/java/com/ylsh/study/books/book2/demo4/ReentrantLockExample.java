package com.ylsh.study.books.book2.demo4;

import java.math.BigDecimal;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void  writer(){
        try {
            condition.await();
            condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        BigDecimal
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();

    }
    public static void main(String[] args) {
        final ReentrantLockExample example = new ReentrantLockExample();

        for(int idx = 0;idx < 3;idx++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    example.writer();
                }
            },"线程" + idx).start();
        }
    }
}
