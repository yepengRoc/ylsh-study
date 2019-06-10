package com.ylsh.study.books.book2.demo7;


import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize){
        if(initialSize > 0){
            for(int i= 0;i < initialSize;i++ ){
                pool.addLast(ConnectionDriver.createCon());
            }
        }
    }
    public void releaseConn(Connection conn){

        synchronized (pool){
            pool.addLast(conn);
            pool.notifyAll();
        }
    }

    public Connection getConn(long mills) throws Exception{
        synchronized(pool){
            if(mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long futureTime = System.currentTimeMillis() + mills;
                long remain = mills;
                while(remain > 0 && pool.isEmpty()){
                    pool.wait(remain);
                    remain = futureTime - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
