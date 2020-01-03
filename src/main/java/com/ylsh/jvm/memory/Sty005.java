package com.ylsh.jvm.memory;

/**
 * jmap
 * jstat
 * jhat
 *
 * jcmd(从jdk1.7开始增加的命令)
 * 1 jcmd pid VM.flags:查看jvm启动参数
 * 2 jcmd pid help:列出当前运行的java进程执行的操作
 * jcmd pid PerfCounter.print 查看jvm性能相关参数
 * jcmd pid VM.uptime 查看jvm的启动时长
 * jcmd pid GC.class_histogram 查看系统中类的统计信息
 * jcmd pid Thread.print 查看系统堆栈信息
 * jcmd pid GC.heap_dump filename 导出heap dump 文件，导出的文件可以通过jvisualvm查看
 * jcmd pid VM.system_properties 查看jvm的属性值
 * jcmd pid VM.command_line 查看jvm启动的命令行参数值
 *
 * jstack 可以查看或是导出java应用程序中线程的堆栈信息
 *
 * jmc: Java Mission Control
 * jfr: Java Flight Recorder  java飞行器，进行数据的实时统计
 *
 * VisualVm OQL
 *  select classof(classlaoder).name from instanceof java.lang.ClassLoader classloader
 */
public class Sty005 {

    public static void main(String[] args) {

        while(true){
            System.out.println("hello world");
        }

    }
}
