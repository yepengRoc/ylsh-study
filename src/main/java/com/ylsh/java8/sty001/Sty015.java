package com.ylsh.java8.sty001;

public class Sty015 extends MeInferfaceImpl1 implements MeInterface2{
    /**
     * 如果有多个接口，每个接口中都有相同的默认实现
     * 如果接口有实现，则调用接口的实现类方法
     * @param args
     */
    public static void main(String[] args) {
        Sty015 sty015 = new Sty015();
        sty015.myMthod();
    }
}
