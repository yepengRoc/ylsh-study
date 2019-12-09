package com.ylsh.study.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSty {


    public static void main(String[] args)  throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(5);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
////                    countDownLatch.await();
//                    System.out.println("执行了");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();

       /* countDownLatch.countDown();
        countDownLatch.await();*/

    }
}
