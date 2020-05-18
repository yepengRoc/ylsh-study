package com.ylsh.jvm.classloader;

/*
traceclassloading
子类没有加载

 */
public class Sty011 {

    public static void main(String[] args){
        //查看子类是否加载
        System.out.println(Child011.a);//子类加载了，但是没有进行初始化
        //查看子类是否加载
        Child011.doSomething();

    }
}

class Parent011{
    static int a = 3;

    static {
        System.out.println("p static block");
    }
    static void doSomething(){
        System.out.println("do something");
    }
}
class Child011 extends  Parent011{
    static {
        System.out.println("c011 static block");
    }

}