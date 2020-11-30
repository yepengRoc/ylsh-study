package com.ylsh.java8.sty001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sty016 {
    /**
     * 数组 转换为 流的 集中方式
     *
     * 查看 Stream 源码
     * @param args
     */
    public static void main(String[] args) {
        Stream stream = Stream.of("zs", "ls", "ww");

        String[] myArr = new String[]{"h1","h2","h3"};

        Stream stream2 = Stream.of(myArr);

        Stream stream3 = Arrays.stream(myArr);

        List<String> list = Arrays.asList(myArr);
        Stream stream4 = list.stream();


    }

    @Test
    public void test(){
        IntStream.of(new int[]{8,7,6,5}).forEach(System.out::println);
        /**
         * 不 包含 尾
         */
        IntStream.range(3,8).forEach(System.out::println);

        System.out.println("========================");
        /**
         * 包含 尾
         */
        IntStream.rangeClosed(3,8).forEach(System.out::println);
    }
    @Test
    public void tes1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        //reduce  求和  每个元素乘以 2 然后求和
        System.out.println(list.stream().map(i -> 2*i).reduce(0,Integer::sum));
    }
    @Test
    public void  test2(){
        Stream<String> stream = Stream.of("s1", "s12", "s123");
        //将流 转换为数组
        String[] strArr = stream.toArray(len -> new String[len]);

        Arrays.asList(strArr).forEach(System.out::println);


        System.out.println("================");
        List<String> list1 = stream.collect(Collectors.toList());
        /**
         * 比较复杂
         */
        List<String> list2 = stream.collect(() -> new ArrayList<>(),
                (theList, item) -> theList.add(item),(list11,list22) -> list11.addAll(list22));

        List<String> list3 = stream.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
        list3.forEach(System.out::println);
    }
    @Test
    public void test3(){
        Stream<String> stream = Stream.of("s1", "s12", "s123");
        String str = stream.collect(Collectors.joining(Collectors.joining().toString()));
        System.out.println(str);
    }
    @Test
    public void test4(){
        List<String> list = Arrays.asList("s1", "s12", "s123");
        list.stream().map(String :: toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("======");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        list1.stream().map(item -> item*item).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("========");
        Stream<List<Integer>>  stream = Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5));
        /**
         * flatmap 是一种一队多的转换
         */
        stream.flatMap(lst -> lst.stream()).map(item -> item*item).forEach(System.out::println);


    }

    @Test
    public void test5(){
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        System.out.println(stream.findFirst().get());
        //上面已经执行过一次，流已经关闭了，这里不能再次执行。再次执行的话，需要把上面的一行注释掉
        stream.findFirst().ifPresent(System.out::println);

    }
    @Test
    public void test6(){
        Stream<String> stream = Stream.empty();
        stream.findFirst().ifPresent(System.out::println);

    }
    @Test
    public void test7(){
        /**
         * 从1开始遍历，只取6个值，每个值都加2
         * 这里不包含 1
         */
        Stream.iterate(1,item->item+2).limit(6).forEach(System.out::println);

    }

    @Test
    public void test8(){
        /**
         * 1 3  5 7  9 11
         * 14  18
         * 32
         * 找出该流中大于2的元素，然后每个元素乘以2，然后忽略掉流中的前两个元素，然后再取六中的前两个
         * 元素，最后求流中元素的总和
         */
        Stream<Integer> stream = Stream.iterate(1,item->item+2).limit(6);
        stream.filter(item -> item > 2).mapToInt(item -> item*2).skip(2).limit(2).sum();

        stream.filter(item -> item > 200).mapToInt(item -> item*2).skip(2).limit(2).max().ifPresent(System.out::println);

    }
    @Test
    public void test9(){
        Stream<Integer> stream = Stream.iterate(1,item->item+2).limit(6);
        //静态统计
      /*  IntSummaryStatistics summaryStatistics = stream.filter(item -> item > 2).
                mapToInt(item -> item*2).skip(2).limit(2).summaryStatistics();

        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());

        System.out.println(stream);
        System.out.println(stream.filter(item -> item > 2));
        System.out.println(stream.distinct());*/

        System.out.println(stream);
        Stream<Integer> stream1 = stream.filter(item -> item > 2);
        System.out.println(stream1);
        Stream<Integer> stream2 = stream1.distinct();
        System.out.println(stream2);

    }

}
