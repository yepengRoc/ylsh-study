package com.ylsh.study.books.nettyqwzn.sty3;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsynTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsynTimeServerHandler attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        result.read(buf, buf, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsynTimeServerHandler attachment) {
        attachment.latch.countDown();
    }
}
