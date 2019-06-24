package com.ylsh.study.books.nettyqwzn.sty1;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BioTimeServerHandler implements Runnable {

    private Socket socket;

    public BioTimeServerHandler(Socket socket){
        this.socket = socket;
    }

    public void run() {
        PrintWriter out = null;
        BufferedReader br = null;
        try {
             br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            out = new PrintWriter(this.socket.getOutputStream(), true);
            String curTime = null;
            String body = null;
            while(true){
                body = br.readLine();
                if(null == body){
                    break;

                }
                System.out.println("bio server receive:"+body);

                curTime = System.currentTimeMillis() + "";

                 out.print(curTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
            if(null != br){
                try {
                    br.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(null != out){
                try {
                    out.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

}
