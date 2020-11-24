package com.tj.jdkSource;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConcHashMapTest {

    public static void main(String[] args) {
        /*Pattern pattern =  Pattern.compile("\\D+");

        String locNo1 = "15A1";
        String locNo2 = "15A2";
        Matcher m1 = pattern.matcher(locNo1);
        if(m1.find()){
            System.out.println(m1.group());
        }
        Matcher m2 = pattern.matcher(locNo2);
        System.out.println(m1.group());
        if(true){
            return;
        }*/
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(i < 50){
                    concurrentHashMap.put(i++,i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 50;
                while(i < 100){
                    concurrentHashMap.put(i++, i);
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
