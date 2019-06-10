package com.ylsh.study.books.book2.demo7;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch startCd = new CountDownLatch(1);
    static CountDownLatch endCd = null;


    public static void main(String[] args) {
         int threadCount = 10;
        endCd = new CountDownLatch(threadCount);
        AtomicInteger get = new AtomicInteger();
        AtomicInteger notGet = new AtomicInteger();
        int count = 20;
        for (int i =0;i < threadCount;i++){
            Thread thread = new Thread(new ConnectionRunner(count, get, notGet),"ConnRunnerThread");
            thread.start();
        }
        startCd.countDown();
        try {
            endCd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total invoke" + (threadCount*count));
        System.out.println("get con:" + get);
        System.out.println("notGet con:" + notGet);
    }

    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger get;
        AtomicInteger notGet;

        ConnectionRunner(int count,AtomicInteger get,AtomicInteger notGet){
            this.count = count;
            this.get = get;
            this.notGet = notGet;
        }
        @Override
        public void run() {
            try {
                startCd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(count > 0){
                try {
                    Connection con = pool.getConn(1000);
                    if(con != null){
                        try {
                            con.createStatement();
                            con.commit();
                        } finally {
                           pool.releaseConn(con);
                           get.incrementAndGet();
                        }
                    }else{
                        notGet.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            endCd.countDown();

        }
    }

}
