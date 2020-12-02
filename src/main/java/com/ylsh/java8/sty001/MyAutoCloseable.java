package com.ylsh.java8.sty001;

public class MyAutoCloseable implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("close invok");
    }

    public void doSomething(){
        System.out.println("doSomething");
    }

    public static void main(String[] args) {
        try {
            MyAutoCloseable my = new MyAutoCloseable();
            my.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
