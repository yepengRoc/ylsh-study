package com.ylsh.java8.sty001;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sty021 {

    @Test
    public void test1(){
        List<String> list = Arrays.asList("s1","s2","s1","s3");
        /**
         * 源码解读 collect 方法 TODO
         */
        Set<String> set = list.stream().collect(new MySetCollector<>());

        System.out.println(set);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("s1","s2","s3","s1","s2");

        Set<String> set = new HashSet<>();
        set.addAll(list);
        /**
         * set 转map
         */
        Map<String,String> map = set.stream().collect(new MySetCollector2<>());
    }

    @Test
    public void test3(){
//        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
        List<String> list = Arrays.asList("s1","s2","s3","s1","s2");

        Set<String> set = new HashSet<>();
        set.addAll(list);
        /**
         * set 转map  改为并发
         */
        Map<String,String> map = set.stream().sequential().parallel().collect(new MySetCollector2<>());
    }

    /**
     * Collectors源码查看
     */
    //        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED);
    @Test
    public void test4(){
        List<String> list = Arrays.asList("s1","s2","s3","s1","s2");

        Set<String> set = new HashSet<>();
        set.addAll(list);
        /**
         * set 转map  改为并发
         */
        Map<String,String> map = set.parallelStream().collect(new MySetCollector2<>());
    }

    /**
     * 新用法 直接try 一个 stream流
     */
    @Test
    public void test5(){
        List<String> list = Arrays.asList("s1","s2","s3","s1","s2");

        try(Stream<String> stream= list.stream()){
            stream.onClose(() -> {
                System.out.println("aa");
                throw new NullPointerException("first exp");
            }).onClose(() -> {
                System.out.println("bb");
            }).forEach(System.out::println);
        }
    }
    @Test
    public void test6(){
        List<String> list = Arrays.asList("s1","s2","s3","s1","s2");

        try(Stream<String> stream= list.stream()){
            stream.onClose(() -> {
                System.out.println("aa");
//                throw new NullPointerException("first exp");
            }).onClose(() -> {
                System.out.println("bb");
                throw new NullPointerException("second exp");
            }).forEach(System.out::println);
        }
    }

    public void test7(){
        // Collection parallelStream() 源码查看 TODO
//        Collection
    }

}
