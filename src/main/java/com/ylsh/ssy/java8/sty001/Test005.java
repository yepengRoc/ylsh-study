package com.ylsh.ssy.java8.sty001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test005 {

    @Test
    public void test1(){
        List<Person> listP = new ArrayList<>();

        Person p1 = new Person("zs", 20);
        Person p2 = new Person("ls", 30);
        Person p3 = new Person("ww", 40);

        listP.add(p1);
        listP.add(p2);
        listP.add(p3);



    }
}
