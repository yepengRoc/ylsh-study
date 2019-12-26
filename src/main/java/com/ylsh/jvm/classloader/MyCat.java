package com.ylsh.jvm.classloader;

public class MyCat {

    public MyCat(){
        System.out.println("mycat is loader by :" + this.getClass().getClassLoader());

        System.out.println("from mycat :" + MySample.class);
    }
}
