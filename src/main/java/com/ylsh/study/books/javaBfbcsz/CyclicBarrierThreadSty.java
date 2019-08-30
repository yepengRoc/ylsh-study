package com.ylsh.study.books.javaBfbcsz;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierThreadSty {

    private static CyclicBarrier cyclicBarrier;

    private static AtomicInteger i = new AtomicInteger(0);

    static class ThreadObj implements Runnable{
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("任务" + i.addAndGet(1) + "开始执行");
        }
    }

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {//大家都开始执行时，
                System.out.println("所有任务开始执行");

            }
        });
        for(int i = 0;i< 5;i++){
            new Thread(new ThreadObj()).start();
        }
    }
}
