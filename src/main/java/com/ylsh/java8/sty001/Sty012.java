package com.ylsh.java8.sty001;

import java.util.Arrays;
import java.util.List;

public class Sty012 {
    /**
     * 方法引用
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zs", "ks", "ww");

        list.forEach(item -> System.out.println(item));

        list.forEach(System.out :: println);
    }
}
