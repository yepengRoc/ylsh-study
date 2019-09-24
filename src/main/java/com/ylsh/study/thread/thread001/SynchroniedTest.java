package com.ylsh.study.thread.thread001;

import javax.activation.MailcapCommandMap;

public class SynchroniedTest {

    private Object object = new Object();

    public void serierExe(){
        synchronized (object){
            int a = 1;
            int b = 2;
            System.out.println(a + b);
        }
    }

    public synchronized void serierMethod(){
        int a = 1;
        int b = 2;
        System.out.println(a + b);
    }

    public  synchronized static void serierMethodStatic(){
        int a = 1;
        int b = 2;
        System.out.println(a + b);
    }
    public static void main(String[] args) {
         System.out.println(1);
    }
}
