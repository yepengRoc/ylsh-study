package com.ylsh.jvm.gc;

/**
 * -verbose:gc
 * -Xmx20m
 * -Xms20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC
 */
public class Sty005 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] byte_1 = new byte[4*size];
        System.out.println(1111);
        byte[] byte_2 = new byte[4*size];
        System.out.println(2222);
        byte[] byte_3 = new byte[4*size];
        System.out.println(3333);
        byte[] byte_4 = new byte[2*size];
        System.out.println(4444);
    }
}
