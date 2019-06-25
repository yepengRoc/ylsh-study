package com.ylsh.study.books.nettyqwzn.sty1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * 使用线程池进行优化  实现线程复用
 */
public class BioTimeServer1 {


    public static void main(String[] args) throws Exception{
        int port = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("server start port:"+port);
            Socket socket = null;

            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(10, 20);
            while(true){
                socket = server.accept();
                executePool.executor(new BioTimeServerHandler(socket));
            }
        } finally {
            if(null != server){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;//help  gc
            }
        }


    }
}
