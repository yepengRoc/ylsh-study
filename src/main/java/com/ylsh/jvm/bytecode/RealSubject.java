package com.ylsh.jvm.bytecode;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("from real subject");
    }
}
