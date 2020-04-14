package com.ylsh.jvm.gc;

/**
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m- XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=494304
 * -XX:MaxTenuringThreshold=5
 * -XX:+PrintTenuringDistribution
 *
 * MaxTenuringThreshold作用：在可以自动调节对象晋升（Promote）到老年代阈值的GC中，设置改阈值的最大值。
 * 该参数默认值是15，CMS中默认是6，G1中默认是15（在jvm中，改数值是由4个bit来表示的，即 1111 所以最大值是15）
 *
 * 经历了多次GC后，存活的对象会在From Survivor与To Survivor之间来回存放，而这里面的一个前提是这两个空间有足够的大小来存放数据，在GC算法中，
 * 会计算每个对象年龄的大小，如果达到某个年龄后发现总大小已经大于Survivor空间的50%，那么这时就要调整阈值，不能再继续等到默认的15次GC后才完成晋升，
 * 因为这样会导致Survivor空间不足，所以需要调整阈值，让这些存活的对象尽快完成晋升
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
