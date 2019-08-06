package com.ylsh.study.books.javaBfbcsz;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sty002 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        lock.unlock();


        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

        //初始化值，初始化版本
        AtomicStampedReference atomicStam = new AtomicStampedReference(100,1);
    }
}
