package com.ylsh.jvm.bytecode;

import java.util.Date;

public class Sty007 {
}

class Animal{
    public void test(String str){
        System.out.println("animal str");
    }
    public void test(Date date){
        System.out.println("animal data");
    }
}

class Dog extends Animal{

}
