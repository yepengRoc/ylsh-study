package com.ylsh.study.books.nettyqwzn.sty2;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTimeClientHandle implements  Runnable {


    private Selector selector;

    private SocketChannel sc;

    private int port;

    private String host;

    private volatile boolean stop;


    public NioTimeClientHandle(String ip,int port){
        try {
            this.host = ip;
            this.port = port;
            sc = SocketChannel.open();
            sc.configureBlocking(false);

          selector = Selector.open();
            /*  sc.register(selector, SelectionKey.OP_WRITE);*/
        } catch (IOException e) {
            e.printStackTrace();
            if(null != selector){
                try {
                    selector.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(null != sc){
                try {
                    sc.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            System.exit(-1);

        }
    }
    public void run() {
        try {
            doConnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        while(!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> setKeys =  selector.selectedKeys();
                Iterator<SelectionKey> it = setKeys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(key != null){
                        key.cancel();
                        if(null != key.channel()){
                            key.channel().close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //多路复用器关闭，注册在上面的资源也会进行关闭 channel pipe
        if(null != selector){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void handInput(SelectionKey key) throws  Exception{
        if(key.isValid()){
            SocketChannel sc = (SocketChannel) key.channel();
            if(key.isConnectable()){

                if(sc.finishConnect()){
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite(sc);
                }else{
                    System.exit(-1);
                }
            }
            if(key.isReadable()){
                ByteBuffer readB = ByteBuffer.allocate(1024);
                int len = sc.read(readB);
                if(len > 0){
                    readB.flip();
                    byte[] bArr = new byte[readB.remaining()];
                    String body = new String(bArr, "UTF-8");
                    System.out.println("nio client recv:" + body);
                    this.stop = true;

                }else if(len < 0){
                    key.cancel();
                    sc.close();
                }

//                int len = readB.get(bArr);

            }

        }
    }

    private void doConnect() throws Exception{

        if(sc.connect(new InetSocketAddress(host,port))){
            sc.register(selector, SelectionKey.OP_WRITE);
            doWrite(sc);
        }else{
            sc.register(selector, SelectionKey.OP_CONNECT);
        }

    }

    private void doWrite(SocketChannel sc) throws  Exception{
        byte[] bArr = "nio client".getBytes();
        ByteBuffer writeB = ByteBuffer.allocate(1024);
        writeB.put(bArr);
        writeB.flip();
        sc.write(writeB);
        if(!writeB.hasRemaining()){
            System.out.println("nio send 2 serer suc");
        }

    }
}
