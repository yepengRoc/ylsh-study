package com.ylsh.java8.sty001;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Sty022 {

    public void test(Consumer<Integer> consumer){

        consumer.accept(100);

    }
    @Test
    public void test1(){
        Sty022 sty = new Sty022();

        Consumer<Integer> co = i -> System.out.println(i);

        IntConsumer intConsumer = i -> System.out.println(i);

        System.out.println(co instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        sty.test(co);//面向对象的方式
        sty.test(co::accept);//函数式方式
        sty.test(intConsumer::accept);//函数式方式
    }
    @Test
    public void test2(){
        List<String> list = Arrays.asList("s1","s2","s3","s1","s2");
        list.stream().map(item -> item).forEach(System.out::println);
    }
}
