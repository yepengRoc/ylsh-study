package com.ylsh.study.books.nettyqwzn.sty7;

import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

public class ProtobufSty {

    /**
     * 处理半包 ProtobufVarint32FramDecoder
     * 继承半包解码器LengthFieldBasedFrameDecoder
     * 继承ByteToMessageDecoder类，自己处理半包消息
     */
    public void test(){
        new ProtobufVarint32FrameDecoder();
    }
}
