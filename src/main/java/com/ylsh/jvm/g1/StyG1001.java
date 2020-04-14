package com.ylsh.jvm.g1;

/**
 * -verbose:gc
 * -Xms10m
 * -Xmx10m
 * -XX:+UseG1GC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxGCPauseMillis=200m
 */
public class StyG1001 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] b_1 = new byte[size];
        byte[] b_2 = new byte[size];
        byte[] b_3 = new byte[size];
        byte[] b_4 = new byte[size];
        System.out.println("hello word");
    }
}
/**
 * 2020-04-14T14:37:00.342-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0057149 secs]
 *    [Parallel Time: 4.0 ms, GC Workers: 8]
 *       [GC Worker Start (ms): Min: 214.5, Avg: 214.8, Max: 215.6, Diff: 1.0]
 *       [Ext Root Scanning (ms): Min: 0.5, Avg: 1.2, Max: 1.7, Diff: 1.2, Sum: 9.8]
 *       [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *          [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
 *       [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *       [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *       [Object Copy (ms): Min: 1.7, Avg: 2.0, Max: 2.3, Diff: 0.6, Sum: 15.9]
 *       [Termination (ms): Min: 0.0, Avg: 0.2, Max: 0.4, Diff: 0.4, Sum: 2.0]
 *          [Termination Attempts: Min: 1, Avg: 3.1, Max: 6, Diff: 5, Sum: 25]
 *       [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.0, Sum: 0.4]
 *       [GC Worker Total (ms): Min: 2.7, Avg: 3.5, Max: 3.8, Diff: 1.1, Sum: 28.1]
 *       [GC Worker End (ms): Min: 218.3, Avg: 218.3, Max: 218.4, Diff: 0.1]
 *    [Code Root Fixup: 0.0 ms]
 *    [Code Root Purge: 0.0 ms]
 *    [Clear CT: 0.2 ms]
 *    [Other: 1.5 ms]
 *       [Choose CSet: 0.0 ms]
 *       [Ref Proc: 1.1 ms]
 *       [Ref Enq: 0.0 ms]
 *       [Redirty Cards: 0.2 ms]
 *       [Humongous Register: 0.0 ms]
 *       [Humongous Reclaim: 0.0 ms]
 *       [Free CSet: 0.0 ms]
 *    [Eden: 3072.0K(4096.0K)->0.0B(2048.0K) Survivors: 0.0B->1024.0K Heap: 4920.9K(10.0M)->2952.4K(10.0M)]
 *  [Times: user=0.02 sys=0.01, real=0.00 secs]
 * 2020-04-14T14:37:00.348-0800: [GC concurrent-root-region-scan-start]
 * 2020-04-14T14:37:00.349-0800: [GC concurrent-root-region-scan-end, 0.0012543 secs]
 * 2020-04-14T14:37:00.349-0800: [GC concurrent-mark-start]
 * 2020-04-14T14:37:00.349-0800: [GC concurrent-mark-end, 0.0001069 secs]
 * 2020-04-14T14:37:00.350-0800: [GC remark 2020-04-14T14:37:00.350-0800: [Finalize Marking, 0.0008430 secs] 2020-04-14T14:37:00.350-0800: [GC ref-proc, 0.0000544 secs] 2020-04-14T14:37:00.350-0800: [Unloading, 0.0007132 secs], 0.0017719 secs]
 *  [Times: user=0.01 sys=0.00, real=0.00 secs]
 * 2020-04-14T14:37:00.351-0800: [GC cleanup 5062K->5062K(10M), 0.0004737 secs]
 *  [Times: user=0.00 sys=0.00, real=0.00 secs]
 * hello word
 * Heap
 *  garbage-first heap   total 10240K, used 5000K [0x00000007bf600000, 0x00000007bf700050, 0x00000007c0000000)
 *   region size 1024K, 2 young (2048K), 1 survivors (1024K)
 *  Metaspace       used 3187K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 347K, capacity 388K, committed 512K, reserved 1048576K
 *
 * Process finished with exit code 0
 **/