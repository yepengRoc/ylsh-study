package com.ylsh.study.books.nettyqwzn.sty8;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {

    private  static final String DEFAULT_URL = "";
     public void run(final int port,final int url){
         EventLoopGroup workGroup = new NioEventLoopGroup();
         EventLoopGroup bossGroup = new NioEventLoopGroup();

         ServerBootstrap b = new ServerBootstrap();

         b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
             @Override
             protected void initChannel(SocketChannel socketChannel) throws Exception {
                 socketChannel.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                 /**
                  * 将多个消息转换为单一的fullhttprequest 或fullhtpptrequest
                  * http解码器在每个http消息中会生成多个消息对象
                  * 1 httprequest/httpresponse
                  * 2httpcontent
                  * 3lasthttpcontent
                  */
                 socketChannel.pipeline().addLast("http-aggregretor", new HttpObjectAggregator(65536));
                 socketChannel.pipeline().addLast("http-encoder", new HttpRequestEncoder());
                 socketChannel.pipeline().addLast("http-encoder", new HttpRequestEncoder());
                 /**
                  * 支持异步发送大的码流，但不占用太多内存，防止发生java内存溢出错误
                  */
                 socketChannel.pipeline().addLast("http-chunker", new ChunkedWriteHandler());
//                 socketChannel.pipeline().addLast("http-chunker", new HttpFileServerHandler(url));
             }
         });

     }
}
