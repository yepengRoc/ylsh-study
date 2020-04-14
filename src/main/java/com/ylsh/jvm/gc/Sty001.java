package com.ylsh.jvm.gc;

import org.junit.Test;

/**
 * 这只jvm参数：
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m- XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -verbose:gc  记录gc详细信息
 * -Xms20m  堆内存最小2om
 * -Xmx20m   堆内存最大20m
 * -Xmn10m  堆内存中的yong generation 10m
 * -XX:+PrintGCDetails  打印gc信息
 * -XX:SurvivorRatio=8  设置堆内存中yong generation中eden区和suvrivor区的比例
 *
 *  java -XX:+PrintCommandLineFlags -version 打印虚拟机信息和虚拟机参数
 *
 *  PretenureSizeThreshold:设置对象超过多大时直接在老年代进行分配
 *
 */
public class Sty001 {

    /**
     * [GC (Allocation Failure) [PSYoungGen: 7016K->896K(9216K)] 7016K->4988K(19456K), 0.0025305 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     * hello world
     * Heap
     *  PSYoungGen      total 9216K, used 4283K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     *   eden space 8192K, 41% used [0x00000007bf600000,0x00000007bf94ecb0,0x00000007bfe00000)
     *   from space 1024K, 87% used [0x00000007bfe00000,0x00000007bfee0000,0x00000007bff00000)
     *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
     *  ParOldGen       total 10240K, used 4092K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     *   object space 10240K, 39% used [0x00000007bec00000,0x00000007befff020,0x00000007bf600000)
     *  Metaspace       used 3179K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 346K, capacity 388K, committed 512K, reserved 1048576K
     *
     *   PSYoungGen 表示新生代使用的是Parallel Scavenge 垃圾收集器
     *   ParOldGen 表示老年代使用的是Parallel Old垃圾收集器
     *
     *   [PSYoungGen: 7016K->896K(9216K)] 7016K->4988K(19456K), 0.0025305 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     *   7016K->896K(9216K)
     *   年轻代垃圾回收前的使用容量-》垃圾回收后的使用容量（年轻代总可以使用容量。因为surivivor每次只有一个可用，所以这里应该是9m可用）
     *
     *  新生代释放：7016 - 896 = 6120
     *  总堆释放： 7016 - 4988 = 2028
     *  6120 - 2028 = 4092 说明有这么多对象进入到了老年代
     */

    public static void main(String[] args){
        int size = 1021*1024;

        byte[] alloc1 = new byte[2 * size];
        byte[] alloc2 = new byte[2 * size];
        byte[] alloc3 = new byte[3 * size];

        System.out.println("hello world");
    }

    /**
     * [GC (Allocation Failure) [PSYoungGen: 8192K->1008K(9216K)] 8192K->1427K(19456K), 0.0016765 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [PSYoungGen: 6652K->992K(9216K)] 7070K->5641K(19456K), 0.0028158 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     * hello world
     * Heap
     *  PSYoungGen      total 9216K, used 7330K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     *   eden space 8192K, 77% used [0x00000007bf600000,0x00000007bfc30928,0x00000007bfe00000)
     *   from space 1024K, 96% used [0x00000007bff00000,0x00000007bfff8020,0x00000007c0000000)
     *   to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
     *  ParOldGen       total 10240K, used 4649K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     *   object space 10240K, 45% used [0x00000007bec00000,0x00000007bf08a600,0x00000007bf600000)
     *  Metaspace       used 5097K, capacity 5264K, committed 5504K, reserved 1056768K
     *   class space    used 594K, capacity 627K, committed 640K, reserved 1048576K
     *
     *
     *
     *
     */

    @Test
    public  void test(){
        int size = 1021*1024;

        byte[] alloc1 = new byte[2 * size];
        byte[] alloc2 = new byte[2 * size];
        byte[] alloc3 = new byte[3 * size];
        byte[] alloc4 = new byte[3 * size];

        System.out.println("hello world");
    }
}



