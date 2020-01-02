package com.ylsh.jvm.memory;


/**
 * 使用jvisualvm检测死锁
 */
public class Sty003 {

    public static void main(String[] args){
        new Thread(() ->{
            A.method();
        }).start();

        new Thread(() ->{
            B.method();
        }).start();
    }
}

class A{

    public static synchronized void method(){
        System.out.println("method from a");
        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class B{

    public static synchronized void method(){

        System.out.println("method from b");

        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
