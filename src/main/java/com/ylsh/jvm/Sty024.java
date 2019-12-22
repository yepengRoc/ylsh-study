package com.ylsh.jvm;

import javax.activation.MailcapCommandMap;

public class Sty024 implements Runnable {

    private Thread thread;

    public Sty024() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        System.out.println("class:" + classLoader.getClass());

        System.out.println("parent:" + classLoader.getParent().getClass());
    }

    public static void main(String[] args){
        new Sty024();
    }
}
