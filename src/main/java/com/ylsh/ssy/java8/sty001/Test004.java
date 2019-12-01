package com.ylsh.ssy.java8.sty001;

import java.util.*;

/**
 * lambda表达式，是没有声明的方法，即没有访问修饰符、返回值和名字
 * 作用：
 * 传递行为，不仅是值。
 * 1提升抽象层次
 * 2api重用性更好
 * 3更加灵活
 * 基本语法：
 * （参数）-> {逻辑}
 * 例如：（arg1,arg2） -> {逻辑}
 * (类型 arg1,类型 arg2) - {逻辑}
 * 可以指定参数的类型，也可以不指定，不指定的前提是可以通过上下文推断出来。
 *
 * （int a,int b） -> {return a+b}
 * () -> 42
 * () -> return 3
 *
 * lambda结构：
 *  可以有0或多个参数
 *  可以声明参数类型，也可以不声明-根据上下文进行推断
 *  参数必须在（）内，多个参数有逗号分割
 *  空的（）标示无参
 *  只有一个参数，且类型可以推导，则圆括号可以省略
 *  主体可以有一条或多条语句
 *  如果主体只有一条则{}也可以省略。匿名函数返回的类型和该主体表达式一致（不用显示的return.）
 *  如果主体包含多于一条的语句，则需要用{}包含。匿名函数的返回类型与代码块一致，若没有则返回空
 */
public class Test004 {

    public static void main(String[] args){
        //对名字进行排序
        List<String> list = new ArrayList<>();

        list.add("zhansan");
        list.add("lisi");
        list.add("wangwu");

        Collections.sort(list,(String o1,String o2) -> {
            return o2.compareTo(o1);
        });
        //直接逆序
         Collections.sort(list, Comparator.reverseOrder());
        /**
         * 更加简介。因为list存储的类型已经是清楚的，可以推断出来。compare作为返回
         */
        Collections.sort(list,(o1,o2) -> o2.compareTo(o1));


    }
}
