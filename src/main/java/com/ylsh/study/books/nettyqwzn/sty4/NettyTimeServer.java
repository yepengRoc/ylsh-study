package com.ylsh.study.books.nettyqwzn.sty4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyTimeServer {

    public void bind(int port){
//        EventLoop
        //reactor线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();//接收客户端连接
        EventLoopGroup workGroup = new NioEventLoopGroup();//记性 socketchannel 网络的读写

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)//对应jdk nio中的 serversocketchannel
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChildChannelHandler());//reactor 模式中的handler
        try {
            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            //等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            //释放线程池资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) {
         int port = 8080;
         new NettyTimeServer().bind(port);
    }
}
