package com.ylsh.java8.sty001;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sty020 {

    @Test
    public void test1(){

        List<String> list = Arrays.asList("s1", "s35", "s478");

        Collections.sort(list,(l1,l2) -> l1.length() - l2.length());
//        Collect

        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());

//        Collections.sort(list,Comparator.comparingInt(item -> item.length()).reversed());
        Collections.sort(list,Comparator.comparingInt((Object item)-> 1).reversed());
        Collections.sort(list,Comparator.comparingInt(String :: length).reversed());
        /**
         * Comparator 源码查看 TODO
         */
        //String.CASE_INSENSITIVE_ORDER  排序忽略大小写
        Collections.sort(list,Comparator.comparingInt(String :: length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        Collections.sort(list,Comparator.comparingInt(String :: length).thenComparing((item1,item2) -> item1.toLowerCase().compareTo(item2.toLowerCase())));
        Collections.sort(list,Comparator.comparingInt(String :: length).thenComparing(Comparator.comparing(String::toLowerCase)));
        Collections.sort(list,Comparator.comparingInt(String :: length).thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
        Collections.sort(list,Comparator.comparingInt(String :: length).reversed().thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
        Collections.sort(list,Comparator.comparingInt(String :: length).reversed().thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder()))
        .thenComparing(Comparator.reverseOrder()));







    }
}
