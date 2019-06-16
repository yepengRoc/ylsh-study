package com.ylsh.study.books.book2.demo5;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 用于线程之间的数据交互
 */
public class Piped {
    public static void main(String[] args) {
//        PipedOutputStream
//        PipedInputStream
        //上面是针对字节的操作.下面是针对字符的操作
//        PipedWriter
//        PipedReader

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
