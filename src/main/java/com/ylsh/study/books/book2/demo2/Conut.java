package com.ylsh.study.books.book2.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 记数测试。 安全和非安全方式进行
 * atomic 是从 jdk 1.5开始提供的 基于cas 实现的线程安全操作方式
 */
public class Conut {

    private AtomicInteger atomicI = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {
        final Conut count = new Conut();
        List<Thread> ts = new ArrayList<Thread>();
        for(int i = 0; i< 100; i++){
            ts.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j < 1000;j++){
                        count.cnt();
                        count.safeCnt();
                    }

                }
            }));
        }
        for(Thread td : ts){
            td.start();
        }
        for(Thread td : ts){
            try {
                td.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count.i);
        System.out.println(count.atomicI.get());
    }

    public void cnt(){
        i++;
    }

    /**
     * i++ 不具有原子性
     */
    public void safeCnt(){
        for(;;){
            int i = atomicI.get();
            boolean rst = atomicI.compareAndSet(i,++i);
            if(rst){
                break;
            }
        }
    }

}
