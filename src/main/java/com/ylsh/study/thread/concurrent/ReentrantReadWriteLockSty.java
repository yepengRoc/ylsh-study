package com.ylsh.study.thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockSty {

    public static void main(String[] args) {
        ReentrantReadWriteLock rwLokc = new ReentrantReadWriteLock();

        Lock readLock = rwLokc.readLock();
        Lock writeLock = rwLokc.writeLock();
    }
}
