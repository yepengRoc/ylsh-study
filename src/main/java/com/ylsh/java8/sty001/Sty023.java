package com.ylsh.java8.sty001;

public class Sty023 {
    Runnable r1 = () -> System.out.println(this);

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    public static void main(String[] args) {
        Sty023 sty = new Sty023();

        Thread t1 = new Thread(sty.r1);

        t1.start();

        Thread t2 = new Thread(sty.r2);
        t2.start();
    }
}
