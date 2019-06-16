package com.ylsh.study.books.book2.demo5;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
    //查看jvm运行了哪些线程
    public static void main(String[] args) {
        //获取java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取monitor 和synchronizer信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo : threadInfos){
            System.out.println("线程id:" + threadInfo.getThreadId() + "线程名称：" + threadInfo.getThreadName());
        }
    }
}
