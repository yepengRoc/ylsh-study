package com.ylsh.jvm.classloader;

public class Sty009 {

    static {
        System.out.println("sty009 static block");
    }

    public static void main(String[] args){
        //子类的使用会导致父类的初始化
        System.out.println(Child009.b);
//        System.out.println(Child009.a);
    }
}

class Parent009{
    static int a = 3;
    static {
        System.out.println("p static block");
    }
}

class Child009 extends Parent009{
    static int b = 4;
    static {
        System.out.println("c static block");
    }
}