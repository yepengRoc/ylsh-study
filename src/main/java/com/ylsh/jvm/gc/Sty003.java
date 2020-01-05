package com.ylsh.jvm.gc;

/**
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m- XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=494304
 * -XX:MaxTenuringThreshold=5
 * -XX:+PrintTenuringDistribution
 *
 *
 */
public class Sty003 {

    public static void main(String[] args){
        int size = 1021*1024;

        byte[] alloc1 = new byte[2 * size];
        byte[] alloc2 = new byte[2 * size];
        byte[] alloc3 = new byte[2 * size];
        byte[] alloc4 = new byte[2 * size];

        System.out.println("hello world");
    }
}
