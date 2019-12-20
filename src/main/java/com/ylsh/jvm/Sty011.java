package com.ylsh.jvm;

/*
traceclassloading
子类没有加载

 */
public class Sty011 {

    public static void main(String[] args){
        //查看子类是否加载
        System.out.println(Child011.a);
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