package com.ylsh.study.books.nettyqwzn.sty3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsynTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;

    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsynTimeServerHandler(int port){
        try {
            this.port = port;
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress("127.0.0.1", port));
            System.out.println("aio time server port:" + port);
        } catch (IOException e) {
            e.printStackTrace();

            if(null != asynchronousServerSocketChannel){
                try {
                    asynchronousServerSocketChannel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            asynchronousServerSocketChannel = null;
            System.exit(-1);
        }
    }


    public void run() {
        latch = new CountDownLatch(1);//完成一组正在执行的操作之前，允许线程一直阻塞
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {
        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
