package com.ylsh.study.books.book2.demo1;

public class DeadLock {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) throws  Exception{
        Thread td1 = new Thread(new Runnable() {
            @Override
            public void run(){
                synchronized (lock1){
                    try {
                        Thread.sleep(2000);
                        System.out.println("线程1 执行 锁lock1");
                        synchronized (lock2){
                            System.out.println("线程1 执行 锁lock2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });


        Thread td2 = new Thread(new Runnable() {
            @Override
            public void run(){
                synchronized (lock2){
                    try {
                        Thread.sleep(2000);
                        System.out.println("线程2 执行 锁lock2");
                        synchronized (lock1){
                            System.out.println("线程1 执行 锁lock1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        td1.start();
        td2.start();

    }
    class Task implements Runnable{
        @Override
        public void run() {

        }
    }



}
