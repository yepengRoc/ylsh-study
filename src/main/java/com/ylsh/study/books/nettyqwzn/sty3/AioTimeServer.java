package com.ylsh.study.books.nettyqwzn.sty3;

public class AioTimeServer {

    public static void main(String[] args) {
         int port = 8080;

        AsynTimeServerHandler asynTimeServerHandler = new AsynTimeServerHandler(port);
        new Thread(asynTimeServerHandler,"AIO timeserverhandler-001").start();
    }
}
