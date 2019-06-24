package com.ylsh.study.books.nettyqwzn.sty1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioTimeServer1 {


    public static void main(String[] args) throws Exception{
        int port = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("server start port:"+port);
            Socket socket = null;
            while(true){
                socket = server.accept();
                new Thread(new BioTimeServerHandler(socket)).start();

            }
        } finally {
            if(null != server){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
