package com.ylsh.jvm.classloader;

import java.util.Random;

public class Sty008 {

    public static void main(String[] args){
        System.out.println(FinalTest.x);//仅仅打印不用对类FinalTest进行初始化
        System.out.println(FinalTest.y);//编译时不确定，需要对finaltest进行初始化
    }
}

class FinalTest{
    public  static final int x = 1;

    public static final int y = new Random().nextInt(5);

    static {
        System.out.println("static block");
    }
}
