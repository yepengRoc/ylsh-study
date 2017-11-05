package com.ylsh.study.thread.thread001;

import org.junit.Test;

public class TestThread {

	@Test
	public void testThread(){
		MyThread t1 = new MyThread();
		t1.start();
//		t1.run();
		
		RunnableThread r1 = new RunnableThread();
		new Thread(r1).start();
		
		System.out.println("主线程：" + Thread.currentThread().getName() + ":" + Thread.currentThread().getId());
	}
}
