package com.ylsh.jvm.classloader;


/**
 * 静态代码块或变量，在这星期，是从上往下按顺序执行。
 * cnt1首先执行
 * new 执行构造函数cnt1已经为1,cnt2 默认为0
 * cnt2从新赋值为2
 *
 */
public class Sty006 {
    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();

        System.out.println(Singleton.cnt1);
        System.out.println(singleton.cnt2);
    }
}


class Singleton{

    public  static int cnt1 = 1;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        cnt1++;
        cnt2++;
        System.out.println(cnt1);
        System.out.println(cnt2);
    }

    public static int cnt2 = 2;

    public static Singleton getInstance(){
        return singleton;
    }
}