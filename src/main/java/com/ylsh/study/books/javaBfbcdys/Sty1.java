package com.ylsh.study.books.javaBfbcdys;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sty1 {


    public void test(){
        try {
            //排它锁
            ReentrantLock lock = new ReentrantLock();
            Condition condition = lock.newCondition();
            lock.lock();
            condition.await();
            condition.signal();
            condition.signalAll();
            lock.unlock();
            //共享锁
            Semaphore semaphore = new Semaphore(10);//限制最多有这么多线程可运行
            semaphore.acquire();
            semaphore.release();

            CountDownLatch countDownLatch = new CountDownLatch(10);//控制这么多线程一起执行
            countDownLatch.await();
            countDownLatch.countDown();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读写锁测试
     */
    public void readWriteLockTest(){

    }
    public static class Cache{
        static Map<String,Object> map = new HashMap<String,Object>();
        static ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
        static ReentrantLock lock = new ReentrantLock();
        static Lock r = rw1.readLock();
        static Lock w = rw1.writeLock();

        public static final Object get(String key){
          /*  Object obj = new Object();
            obj.notify();*/
            lock.lock();
            try {
                Condition condition = lock.newCondition();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r.lock();
            try {
                return map.get(key);
            }finally {
                r.unlock();
            }
        }

        public static final Object put(String key,Object object){
            w.lock();
            try {
                return map.put(key, object);
            } finally {
                w.unlock();
            }

        }

        public static final void clear(){
            w.lock();
            try {
                map.clear();
            } finally {
                w.unlock();
            }

        }


    }

    public static void main(String[] args) {
         System.out.println(1 << 16);
    }
}
