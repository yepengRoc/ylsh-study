package com.ylsh.jvm.classloader;

import sun.misc.Launcher;

public class Sty013 {

    public static void main(String[] args){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        while(null != classLoader.getParent()){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);

        }
    }
}
/**
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * sun.misc.Launcher$ExtClassLoader@214c265e
 *
 * 都是Launcher的内部类
 */