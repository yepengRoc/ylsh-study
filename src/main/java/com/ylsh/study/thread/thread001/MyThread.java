package com.ylsh.study.thread.thread001;

import java.util.AbstractQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public  class MyThread extends Thread {

	public void run(){
//	    AbstractQueuedSynchronizer
		System.out.println("基本线程建立");
	}
}
