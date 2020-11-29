package com.ylsh.java8.sty001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Sty018 {
    @Test
    public void test1(){
        List<String> list = new ArrayList<>(5000000);

        for(int i=0;i < 5000000; ++i){
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("begin sort");
        long startTime = System.nanoTime();
        list.parallelStream().sorted().count();
        long endTime = System.nanoTime();

        long mills = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("sort wast time:" + mills);
    }
    @Test
    public void test2(){
        List<String> list = Arrays.asList("s1","s11","s123");

        list.stream().mapToInt(item -> item.length()).filter(len -> len == 5).findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(item -> {
            int len = item.length();
            System.out.println(item);
            return len;
        }).filter(len -> len == 5).findFirst().ifPresent(System.out::println);
    }

    @Test
    public void test3(){
        List<String> list = Arrays.asList("s1 ss","s11 s34","s123 s45");

       List<String[]> rst = list.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList());
       rst.forEach(item -> Arrays.asList(item).forEach(System.out::println));

       //直接转换为 一个String
        List<String> rst1 = list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().
                collect(Collectors.toList());
        rst1.forEach(System.out::println);
    }
}
