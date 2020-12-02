package com.ylsh.java8.sty001;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 20200117 202918
 */
public class Sty019 {

    @Test
    public void test(){

        List<String> list1 = Arrays.asList("s1","s2");
        List<String> list2 = Arrays.asList("s3","s4");

        List<String> list3 = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        list3.forEach(System.out::println);
    }

    /**
     * 分组是 group by
     * 分区是 partition by
     */
    @Test
    public void test1(){
        Student s1 = new Student("zs", 80, 18);
        Student s2 = new Student("ls", 78, 20);

        List<Student> students = Arrays.asList(s1,s2);
        /**
         * 根据名字进行分组
         */
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        /**
         * 根据名称分组，然后统计每个分组的数量
         */
        Map<String, Long> map2 = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        /**
         * 根据名称进行分组，然后统计每个分组中的平均分数
         */
        Map<String, Double> map3 = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getScore)));
        /**
         * 分区。分数大于 90的是一个分区
         */
        Map<Boolean, List<Student>> map4 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
    }
    /**
     * Collector 源码查看 TODO
     */
    @Test
    public void test2(){
        Student s1 = new Student("zs", 80, 18);
        Student s2 = new Student("ls", 78, 20);

        List<Student> students = Arrays.asList(s1,s2);

        List<Student> students1 = students.stream().collect(Collectors.toList());
        students1.forEach(System.out::println);
        System.out.println("------------");

        students.stream().collect(Collectors.counting());
        students.stream().count();
        students.stream().collect(Collectors.averagingInt(Student::getScore));
        students.stream().collect(Collectors.summingInt(Student::getScore));
        IntSummaryStatistics intSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);

        System.out.println("------------");

        students.stream().map(Student::getName).collect(Collectors.joining());
        students.stream().map(Student::getName).collect(Collectors.joining(","));
        students.stream().map(Student::getName).collect(Collectors.joining(",","<begin>","<end>"));

        System.out.println("------------");
        /**
         * 根据分数分组，分数相同时，根据名称分组
         */
        Map<Integer, Map<String, List<Student>>> map = students.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println(map);
        System.out.println("------------");
        /**
         * 分数为80 进行分区
         */
        Map<Boolean, List<Student>> map2 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 80));
        /**
         * 根据名字进行分组，然后取分组里面分数最小的
         */
        Map<String, Student> map3 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));



    }
}
