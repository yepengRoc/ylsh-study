package com.ylsh.concurrent;

/**
 * 锁粗化
 * JIT编译器在执行动态编译时，若返现前后相邻syn块使用的是同一个锁对象，它会吧这几个syn合并为一个较大的同步块，
 * 好处：代码执行时，无须频繁的进行锁的申请和释放，只需进行一次锁的申请和释放就可以了，提升了性能。
 */
public class Sty006 {

    private Object object = new Object();


    public void method(){


        synchronized (object){
            System.out.println("1");
        }

        synchronized (object){
            System.out.println("2");
        }

        synchronized (object){
            System.out.println("3");
        }


    }
}
