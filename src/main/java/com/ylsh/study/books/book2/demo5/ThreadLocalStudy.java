package com.ylsh.study.books.book2.demo5;

public class ThreadLocalStudy {
    static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        tl.set(1);
        //是 tl 作为key值
        //每个线程中都维护了一个 ThreadLocalMap  其实就是一个map  key 就是 new 的ThreadLocal
        //所以一个线程中想要存放多个值，需要new 多个ThreadLocal

        //ThreadLoclMap 是一个静态类。测试多线程条件是是否共用一个 map TODO
        //hanshcode 讲解 https://blog.csdn.net/acmer_ding/article/details/79416783

    }
}
