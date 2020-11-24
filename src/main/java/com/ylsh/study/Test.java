package com.ylsh.study;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    static volatile  int flag = 0;

    public static Object object = new Object();

    static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {

       /* BigDecimal bigDecimal = new BigDecimal(0.5);
        Integer sum = 3;
        System.out.println(bigDecimal.multiply(new BigDecimal(sum)));*/
//        Integer integer = new Integer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        synchronized (object){

                            object.notifyAll();
                           /* if(integer.incrementAndGet() & 1 == 0){
                                flag = 1;
                                System.out.println(integer.get());
                            }*/
                            object.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
