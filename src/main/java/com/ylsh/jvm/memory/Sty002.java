package com.ylsh.jvm.memory;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
 *
 * java.lang.StackOverflowError 栈内存溢出
 */
public class Sty002 {

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    //加一个睡眠时间，通过jvisualvm进行查看
    public void test(){
        this.length ++;
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        test();
    }

    public static void main(String[] args){

        Sty002 sty002 = new Sty002();

        try {

            sty002.test();
        } catch (Exception e) {
            System.out.println(sty002.getLength());
            e.printStackTrace();
        }
    }
}
