package com.ylsh.jvm.gc;




/**
 * 配置jvm参数
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=494304
 * -XX:PretenureSizeThreshold=494304 大于等于4m的对象直接分配在老年代分配
 * -XX:+UseSerialGC  只有使用此垃圾收集器PretenureSizeThreshold 参数才生效.这里实际验证的时候发现不设置
 *  此垃圾收集器，也直接把大于4m的对象分配在了老年代。
 *  经求证 parallel scavenge 和 UseSerialGC 对此参数都有效，其它不行
 *
 * PretenureSizeThreshold：设置对象超过多大时直接在老年代进行分配
 */
public class Sty002 {

    public static void main(String[] args){
        int size = 1021*1024;

        byte[] alloc = new byte[8 * size];
//        byte[] alloc = new byte[10 * size];


      //  System.out.println("hello world");
    }
}
/**
 * 未配置-XX:+UseSerialGC  发现大于等于4m的对象还是分配在新生代
 * Heap
 *  PSYoungGen      total 9216K, used 3136K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *   eden space 8192K, 38% used [0x00000007bf600000,0x00000007bf9102f0,0x00000007bfe00000)
 *   from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *   to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 *  ParOldGen       total 10240K, used 8168K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   object space 10240K, 79% used [0x00000007bec00000,0x00000007bf3fa010,0x00000007bf600000)
 *  Metaspace       used 3266K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 356K, capacity 388K, committed 512K, reserved 1048576K
 */
