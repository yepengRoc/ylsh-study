package com.ylsh.study.books.nettyqwzn.sty9;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class NettyServerSty {
    /**
     * NioEventLoopGroup实际上就是Reactor线程池
     * 不一定非要创建两个 nioeventloopgroup，也可以只创建一个进行共享
     * group boss被设置到父类的group中。work设置到serverbootstrap中， 此方法被客户端和服务端重用，用于设置工作io线程，执行和调度网络事件的读写
     * chanel 用设置端口监听和链路接入。通过工程类设置不同的channel ，服务端是NioServersocketchannel  客户端 niosocketchannel
     * option 设置内核为此监听端口排队的最大连接数
     *   三次握手来分割队列，
     *    客户端--sync-->服务端
     *    客户端<---sync--服务端
     *    客户端--响应--》服务端
     *    前两个步骤在未完成队列中
     *    最后一个步骤从未完成队列移到完成队列队尾
     *    当进程调用accept时，从已完成队列头部取一个条目给进程，已完成队列为空，则休眠，直至有条目在已完成队列中，被唤醒。
     *    阻塞队列block 需要酌情设置，三次握手延时会导致 阻塞的请求多
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            EventLoopGroup boos = new NioEventLoopGroup();
            EventLoopGroup work = new NioEventLoopGroup();
            ServerBootstrap b = new ServerBootstrap();
            b.group(boos,work).//设置绑定 reactor线程池  处理注册到selector上的的channel 。不仅仅处理网络io 用户自定义和定时任务也有eventloop处理
                    channel(NioServerSocketChannel.class).//对 NioServerSocketChannel 原生api进行了封装，规避底层实现细节。 通过工厂类。反射创建
                    option(ChannelOption.SO_BACKLOG,1024).
                   childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast("",new LengthFieldBasedFrameDecoder(0,0,0));
                }
            });
            ChannelFuture f =  b.bind(8080).sync();//绑定端口号
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
