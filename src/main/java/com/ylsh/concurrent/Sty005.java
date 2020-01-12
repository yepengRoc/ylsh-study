package com.ylsh.concurrent;

/**
 * 编译器对于锁的优化措施：
 *
 * JIT编译器（Just In Time编译器）可以在动态变异同步代码时，使用一种叫做逃逸分析的技术，来通过
 * 该技术判别程序中所使用的锁对象是否只被一个线程所使用，而没有散布到其它线程当中，如果情况就是这样的
 * 话，JTT编译器在编译这个同步代码时就不会生成syn关键在所标识的锁的申请与释放机器码，从而消除了锁的
 * 使用流程。
 */

public class Sty005 {

//    private Object object = new Object();


    public static void main(String[] args){
         Object object = new Object();

        synchronized (object){
            System.out.println("h w");
        }
    }
}
