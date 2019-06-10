package com.ylsh.study.books.book2.demo5;

public class WaiterNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Waiter()).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Notify()).start();
    }

    static class Waiter implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while(flag){
                    try {
                        System.out.println("waiter 等待");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("waiter执行结束");
            }

        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                lock.notifyAll();
                flag = false;
                try {
                    System.out.println("Notify 获取锁");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock){
                System.out.println("Notify 再次枷锁");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
