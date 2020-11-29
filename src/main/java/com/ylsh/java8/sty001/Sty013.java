package com.ylsh.java8.sty001;

import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Sty013 {

    public String getString(Supplier<String> sp){
        return sp.get() + "test";
    }

    /**
     * 传递的行为 给fuc,然后fuc行为 应用到str上
     * @param str
     * @param fuc
     * @return
     */
    public String getString2(String str, Function<String,String> fuc){
        return fuc.apply(str);
    }

    public static void main(String[] args) {
        Student s1 = new Student("zs", 10);
        Student s2 = new Student("ls", 15);

        Student s3 = new Student("ww", 9);

        List<Student> list = Arrays.asList(s1, s2, s3);

        list.sort((st1,st2) -> {
            return st1.getScore() - st2.getScore();
        });
        list.forEach(st -> System.out.println(st));

        list.sort(Student :: cmpByScore);

        StudentCmp studentCmp = new StudentCmp();

        list.sort((st1,st2) -> studentCmp.cmpByScore(st1,st2));

        list.sort(studentCmp :: cmpByScore);


    }
    @Test
    public void test(){
        List<String> citys = Arrays.asList("shanghai","beijing","shenzhen");
        Collections.sort(citys,(c1,c2) -> c1.compareTo(c2));

        Collections.sort(citys,String :: compareToIgnoreCase);
        citys.forEach((item) -> System.out.println(item));
    }
    @Test
    public void test1(){
        Sty013 sty013 = new Sty013();
        System.out.println(sty013.getString(String::new));
        System.out.println(sty013.getString2("hw",String::new));
    }
}
