package com.ylsh.study.books.nettyqwzn.sty1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BioTimeClient {
   public static void main(String[] args) throws  Exception{
       int port = 8080;
       Socket socket = null;
       BufferedReader in = null;
       PrintWriter out = null;

       try {
           socket = new Socket("127.0.0.1",port);
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           out = new PrintWriter(socket.getOutputStream(), true);

           out.println("QUERY TIME ORDER");
           System.out.println("send order 2 server succeed");
           String resp = in.readLine();
           System.out.println("now is:"+resp);
       } finally {
           if(null != socket){
               try {
                   socket.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }

           }
           if(null != in){
               try {
                   in.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(null != out){
               try {
                   out.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
           socket = null;// help gc
       }


   }
}
