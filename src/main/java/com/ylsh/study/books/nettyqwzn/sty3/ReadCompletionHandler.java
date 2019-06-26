package com.ylsh.study.books.nettyqwzn.sty3;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {


    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel){
        if(null != channel){

            this.channel = asynchronousSocketChannel;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] bArr = new byte[attachment.remaining()];
        attachment.get(bArr);


        try {
            String req = new String(bArr, "UTF-8");
            System.out.println("nio server recv :" + req);
            String curTime = new Date() + "";
            doWrite(curTime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private void doWrite(String curTime) {
        if(null != curTime && curTime.length() > 0){

            byte[] bs = curTime.getBytes();
            ByteBuffer write = ByteBuffer.allocate(1024);
            write.put(bs);
            write.flip();
            channel.write(write, write, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if (attachment.hasRemaining()) {
                        channel.write(attachment, attachment, this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
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
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
