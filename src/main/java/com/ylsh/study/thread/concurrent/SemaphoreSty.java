package com.ylsh.study.thread.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreSty {

    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(2);
        //获取执行权
        semaphore.acquire();
        //释放执行权
        semaphore.release();
    }

}
