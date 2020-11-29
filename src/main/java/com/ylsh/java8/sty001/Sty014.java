package com.ylsh.java8.sty001;

public class Sty014 implements MeInterface,MeInterface2{


    public static void main(String[] args) {
        Sty014 cls = new Sty014();
        /**
         * 如果不重写，则调用的是默认实现
         *
         *
         * */
        cls.myMthod();
    }

    @Override
    public void myMthod() {
//        System.out.println("sty014");
        //如果实现多个接口，都有相同的方法，可以通过重写来指定调用的是哪个父类的默认方法
        MeInterface2.super.myMthod();
    }
}
