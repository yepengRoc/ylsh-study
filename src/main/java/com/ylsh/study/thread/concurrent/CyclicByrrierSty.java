package com.ylsh.study.thread.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicByrrierSty {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        cyclicBarrier.await();
        cyclicBarrier.notify();

//        cyclicBarrier.wait();
    }
}
