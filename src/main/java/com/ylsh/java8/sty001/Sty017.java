package com.ylsh.java8.sty001;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sty017 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("s1", "s2", "s3");
        //首字母大写
        list.stream().
                map(item -> item.substring(0,1).toUpperCase() + item.substring(1)).forEach(System.out::println);
        //和上面等效
        list.stream().map(item -> {
            String rst = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return rst;
        }).forEach(System.out::println);
    }
    @Test
    public void test1(){
        IntStream.iterate(0,i ->(i+1)%2).limit(6).distinct().forEach(System.out::println);
    }
}
