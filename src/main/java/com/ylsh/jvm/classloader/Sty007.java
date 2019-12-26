package com.ylsh.jvm.classloader;


/**
 * 类的装载
 */
public class Sty007 {

    public static void main(String[] args) throws Exception{
        //由bootstrap加载的类无父类加载器
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());
        //classpath中的类默认由系统类加载器加载
        Class<?> claz = Class.forName("com.ylsh.jvm.classloader.C");
        System.out.println(claz.getClassLoader());


    }
}

class C{

}
