package com.tj.nettysz.sty1;

import io.netty.util.internal.chmv8.LongAdderV8;

import java.util.concurrent.atomic.LongAdder;

public class EchoServer {

    int port;
    EchoServer(int port){
        this.port = port;
    }

    public void start(){
        LongAdder a = new LongAdder();
        a.add(3);
        LongAdderV8 b = new LongAdderV8();
    }

    public static void main(String[] args) {
        LongAdder a = new LongAdder();
        a.add(3);
    }

}
