package com.ylsh.jvm.classloader;


import java.util.UUID;

/**
 * 常量的值在编辑期不能确定，就不会放入到调用类的常量池中。
 * 当在程序运行时，会导致主动调用这个常量所在的类，会导致常量所在类被初始化
 * 这里的str在编译期不能确定下来。
 * 通过参数TraceClassLoading查看是否加载
 *
 */
public class Sty003 {

    public static void main(String[] args){
        System.out.println(Parent003.str);
    }
}

class Parent003{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("parent003 static code");
    }
}
