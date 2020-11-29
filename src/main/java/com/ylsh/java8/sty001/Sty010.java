package com.ylsh.java8.sty001;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/lang/doc-files/ValueBased.html
 */
public class Sty010 {

    public static void main(String[] args){
//        Optional 源码查看

        Optional<String> optional = Optional.ofNullable("hello");//hello  null

      /*  if(optional.isPresent()){
            System.out.println(optional.get());
        }*/

        optional.ifPresent(item -> System.out.println(item));//推荐使用方式

        System.out.println(optional.orElse("world"));//如果没有则打印 world

        System.out.println(optional.orElseGet(() -> "nihao"));

    }
}
