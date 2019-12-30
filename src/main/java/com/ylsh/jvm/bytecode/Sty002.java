package com.ylsh.jvm.bytecode;

/**
 * 当前类有两个构造函数，可以看到
 * 实例变量的赋值都是在构造函数内完成。构造函数<init>
 *
 * 静态变量或方法的初始化是在<cinit>中完成的
 *
 * bipush 推送到堆
 */
public class Sty002 {

    protected String str = "hello world";

    private int x =5;

    public static Integer in = 10;

    public Sty002(){

    }

    public Sty002(int i){
        System.out.println("abc");
    }


    public static void main(String[] args){
        Sty002 sty002 = new Sty002();

    }

    private synchronized void setX(int x){
        this.x = x;

    }

    private void test(String str){
        synchronized (str){
            System.out.println("hello wordl");
        }
    }

    private synchronized static void test2(){

    }
}
