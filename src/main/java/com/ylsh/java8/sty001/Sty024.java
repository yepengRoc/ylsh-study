package com.ylsh.java8.sty001;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sty024 {

    public void test(){

        List<String> list = Arrays.asList("s1", "s2", "s3");

        Stream<String> stream = list.stream();

        Stream<String> stream1 = stream.map(item -> item + "abc");

        stream1.forEach(System.out::println);
    }

    public void test1(){
        /**
         *      BaseStream
         *
         *      AbstractPipeline
         *
         *     ReferencePipleline
         *
         *     head  statelessop   statefulop
         *=========================================
         *          TerminalOp
         *      find foreach  match reduce
         *
         * www.joda.org
         */
    }
}
