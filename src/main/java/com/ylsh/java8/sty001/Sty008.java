package com.ylsh.java8.sty001;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Sty008 {

    public static void main(String[] args){

        Supplier<Person> supplier = () -> new Person("ls",20);
        System.out.println(supplier.get().getUsrName());
        System.out.println("==============");
        Supplier<Person> supplier2 = Person :: new;
        supplier2.get().getAge();
    }
}
