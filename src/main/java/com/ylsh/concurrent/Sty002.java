package com.ylsh.concurrent;

import com.ylsh.study.javabase.demo1.TrafficLightExtends;
import org.omg.CORBA.OBJ_ADAPTER;

/**
 * 死锁
 */
public class Sty002 {

    public static void main(String[] args){
        CntObj cntObj = new CntObj();

        //加
        new Thread(new Runnable() {
            @Override
            public void run() {

                    cntObj.increase();

            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {

                cntObj.increase();

            }
        });

        //减
        new Thread(new Runnable() {
            @Override
            public void run() {
               cntObj.reduce();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                cntObj.reduce();
            }
        });
    }
}

class CntObj{
    private int cnt = 0;

    public void setCnt(int cnt){
        this.cnt = cnt;

    }
    public int getCnt(){
        return this.cnt;
    }

    public synchronized void increase(){
        try {
//            if(cnt != 0){
//                wait();
//            }
            while(cnt != 0){
                wait();
            }
            cnt++;
            System.out.print(cnt);

            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public synchronized  void reduce(){
        try {
//            if(cnt != 1){
//                wait();
//            }
            while(cnt != 1){
                wait();
            }
            cnt--;
            System.out.print(cnt);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
