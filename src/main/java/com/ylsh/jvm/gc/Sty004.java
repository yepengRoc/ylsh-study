package com.ylsh.jvm.gc;

/**
 * gc参数：
 * -verbose:gc
 * -Xmx200m
 * -Xmn50m
 * -XX:TargetSuvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails
 * -XX:PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:UseParNewGC
 * -XX:MaxTenuringThreshold=3
 */
public class Sty004 {

    public static void main(String[] args) throws Exception {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512*1024];

        myGc();
        Thread.sleep(1000);
        System.out.println(1111);

        myGc();
        Thread.sleep(1000);
        System.out.println(2222);

        myGc();
        Thread.sleep(1000);
        System.out.println(3333);

        myGc();
        Thread.sleep(1000);
        System.out.println(4444);

        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println(4444);

        myGc();
        Thread.sleep(1000);
        System.out.println(4444);
        System.out.println("end");
     }

     private static void myGc(){
        for(int i=0;i < 40; i++){
            byte[] byteArr = new byte[1024 * 1024];

        }
     }
}
