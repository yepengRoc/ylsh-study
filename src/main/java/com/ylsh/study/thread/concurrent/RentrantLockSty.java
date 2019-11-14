package com.ylsh.study.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockSty {

    public static void main(String[] args) throws Exception{
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition rConditon = reentrantLock.newCondition();
        //线程1
        reentrantLock.lock();
        try {
            //业务代码
            rConditon.await(1000L, TimeUnit.MILLISECONDS);
        } finally {
            reentrantLock.unlock();
        }


        //线程2
        rConditon.signal();
    }
}
