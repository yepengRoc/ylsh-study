package com.ylsh.jvm;


import java.net.URL;
import java.util.Enumeration;

public class Sty014 {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "com.ylsh.jvm.Sty013";

        Enumeration<URL> enumeration = classLoader.getResources(resourceName);

        while(enumeration.hasMoreElements()){
            URL url = enumeration.nextElement();

            System.out.println(url);

        }

        Class<?> clazz = String.class;
        //string由bootstrap加载，所以没有类加载器
        System.out.println(clazz.getClassLoader());

    }
}
