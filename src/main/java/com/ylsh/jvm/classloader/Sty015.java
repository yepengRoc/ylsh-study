package com.ylsh.jvm.classloader;

public class Sty015 {

    public static void main(String[] args){
        String[] strArr = new String[2];
        System.out.println(strArr.getClass().getClassLoader());

        Sty015[] arr = new Sty015[2];
        System.out.println(arr.getClass().getClassLoader());

        int[] intArr = new int[2];
        System.out.println(intArr.getClass().getClassLoader());
    }
}
/**
 * null
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * null
 *
 * 为null说明是bootstrap进行加载
 **/