package com.ylsh.jvm.classloader;

public class MySample {

    public MySample(){
        System.out.println("mysamle is loader by :" + this.getClass().getClassLoader());

        new MyCat();
    }
}
