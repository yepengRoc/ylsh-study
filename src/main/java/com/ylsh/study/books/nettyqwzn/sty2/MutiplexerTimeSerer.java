package com.ylsh.study.books.nettyqwzn.sty2;

import io.netty.channel.ServerChannel;
import javafx.scene.paint.Stop;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MutiplexerTimeSerer implements Runnable {

    private ServerSocketChannel svrChannel;

    private Selector selector;

    private volatile boolean stop;

    public MutiplexerTimeSerer(int port) {
        try {
            this.svrChannel = ServerSocketChannel.open();
            selector = Selector.open();
            svrChannel.configureBlocking(false);//非阻塞
            svrChannel.socket().bind(new InetSocketAddress(port),1024);
            svrChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void run() {
        while(!stop){
            try {
                selector.select(1000);//休眠一秒
                Set<SelectionKey> sKeys =  selector.selectedKeys();
                Iterator<SelectionKey> it = sKeys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();

                if (null != selector) {
                    try {
                        selector.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                selector = null;
            }

        }
    }

    private void handleInput(SelectionKey key) throws  Exception{
        if(key.isValid()){
            if(key.isAcceptable()){//处理新接入的请求消息
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readB = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readB);
                if(readBytes > 0){
                    readB.flip();//重置指针，从开头开始读
                    byte[] byteArr = new byte[readB.remaining()];//实际情况可以通过 hasRemain 来判断数据是否取完，进行selector 轮询
                    readB.get(byteArr);
                    String body = new String(byteArr, "UTF-8");
                    System.out.println("nio time server recv data:" + body);
                    String curTime = new Date() + "";
                    doWriter(sc,curTime);

                }else if(readBytes < 0){//链路已经关闭
                    //对端链路关闭
                    key.cancel();
                    sc.close();
                }
            }
        }

    }

    private void doWriter(SocketChannel sc, String curTime) throws Exception{
        if(null != curTime && curTime.length() > 0){
            byte[] bArr = curTime.getBytes();
            ByteBuffer writeBbr = ByteBuffer.allocate(bArr.length);
            writeBbr.put(bArr);
            writeBbr.flip();//设置当前的limit 为position .当前position设置为0
            sc.write(writeBbr);

        }

    }
}
