package com.ylsh.study.books.nettyqwzn.sty2;

import java.nio.channels.ServerSocketChannel;

public class NioTimeServer {

    public static void main(String[] args) {
         int port = 8080;

        ServerSocketChannel serverChannal = null;

        MutiplexerTimeSerer timServer = new MutiplexerTimeSerer(port);
        new Thread(timServer,"NIO-mutiplexe").start();


    }
}
