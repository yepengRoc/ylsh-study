package com.ylsh.study.books.nettyqwzn.sty3;

import javax.xml.transform.sax.TemplatesHandler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements CompletionHandler<Void,AsyncTimeClientHandler>,Runnable {

    private  int port;
    private String ip;

    private AsynchronousSocketChannel channel;

    private CountDownLatch latch;
    public AsyncTimeClientHandler(String ip,int port){
        this.port = port;
        this.ip = ip;
        try {
            channel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] req = "fadfads".getBytes();
        ByteBuffer writeBuf = ByteBuffer.allocate(1024);
        writeBuf.put(req);
        writeBuf.flip();
        channel.write(writeBuf, writeBuf, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()) {
                    channel.write(attachment, attachment, this);

                } else {
                    ByteBuffer readBf = ByteBuffer.allocate(1024);
                    channel.read(readBf, readBf, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte[] bArr = new byte[attachment.remaining()];
                            attachment.get(bArr);
                            try {
                                String content = new String(bArr, "UTF-8");
                                System.out.println("aio client recv:" + content);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                channel.close();
                                latch.countDown();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    channel.close();
                    latch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        try {
            channel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
