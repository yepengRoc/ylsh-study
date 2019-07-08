package com.ylsh.study.books.nettyqwzn.sty5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import org.apache.commons.codec.StringDecoder;

import javax.activation.MailcapCommandMap;

public class DecoderTest {
    public static void main(String[] args)  throws Exception {
        /**
         * 遍历bytebuf,判断看是否有\n 或\r\n。有就以此为结束位置。从可读索引到结束位置区间的字节就组成了一行。
         * 是以换行符为结束标志的解码器，支持携带结束符和不携带结束符，同时支持单行的最大长度。如果连续取最大长度
         * 后还没有出现换行符，就会抛异常，同时忽略到之前读到的异常码流
         */
        new LineBasedFrameDecoder(1024);//单条消息的最大长度
        /**
         * 将接收到的对象转换为字符串
         */
//        new StringDecoder();

        /**
         * 以分隔符作为码流结束标识的消息的解码
         */
        ByteBuf byteBuf = Unpooled.copiedBuffer(("$_").getBytes());//$_作为分隔符
        new DelimiterBasedFrameDecoder(1024,byteBuf);

        /**
         * 按照指定长度的消息进行自动解码
         * 如果是半包消息，fixedlengthFrameDecoder会缓存半包消息并等待下个包到达后进行拼包
         *
         */
        new FixedLengthFrameDecoder(1024);



    }
}
