package com.ylsh.ssy.java8.sty002;


interface  MyInterface{
    void test();

    String toString();
}

public class Sty002 {

    public void test2(MyInterface myInterface){
        myInterface.test();
    }

    public static void main(String[] args){
        Sty002 test002 = new Sty002();

        test002.test2(() -> System.out.println("123"));

        MyInterface my = () -> System.out.println("123");

        test002.test2(my);

        System.out.println(my.getClass());
        System.out.println(my.getClass().getSuperclass());
        System.out.println(my.getClass().getInterfaces().length);
        System.out.println(my.getClass().getInterfaces()[0]);
    }

}
/**
 * 123
 * 123
 * class com.ylsh.ssy.java8.sty001.Test002$$Lambda$2/1029991479
 * class java.lang.Object
 * 1
 * interface com.ylsh.ssy.java8.sty001.MyInterface
 *
 * 说明my是object的一个实例，实现了MyInterface接口。
 * lambda的格式 如果有参数则写一个参数名称 -> 逻辑功能。多行用{}包裹
 *
 */
