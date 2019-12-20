package com.ylsh.jvm;

/**
 * TraceClassLoading 查看 parent010 只定义的时候，是否加载了
 */

public class Sty010 {

    static {
        System.out.println("sty010 static block");
    }
    public static void main(String[] args){

        Parent010 parent010;

        parent010 = new Parent010();
        System.out.println(parent010.a);

        System.out.println(Child010_1.b);
    }

}

class Parent010{
    static int a = 3;

    static{
        System.out.println("p static block");
    }
}

class Child010_1 extends  Parent010{
    static int b = 4;

    static{
        System.out.println("c static block");
    }
}
