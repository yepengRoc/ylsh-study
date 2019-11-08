package com.ylsh.study.thread.concurrent;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockSty {

    public static void main(String[] args) {
        ReentrantReadWriteLock rwLokc = new ReentrantReadWriteLock();

        Lock readLock = rwLokc.readLock();
        Lock writeLock = rwLokc.writeLock();

        readLock.lock();
        readLock.unlock();
        writeLock.lock();
        writeLock.unlock();



        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);
        longAdder.add(2L);
        longAdder.sum();


    }
}
