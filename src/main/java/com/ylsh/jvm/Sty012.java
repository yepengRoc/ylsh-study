package com.ylsh.jvm;

/**
 * 调用ClassLoader的loadclass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
public class Sty012 {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.ylsh.jvm.CL");

        System.out.println(clazz);
        clazz = Class.forName("com.ylsh.jvm.CL");

        System.out.println(clazz);
    }
}

class CL{
    static{
        System.out.println("class CL");
    }
}
/**
 * class com.ylsh.jvm.CL
 * class CL
 * class com.ylsh.jvm.CL
 **/