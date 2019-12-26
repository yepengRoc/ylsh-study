package com.ylsh.jvm.classloader;

import org.junit.Test;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Sty026 {

    public static void main(String[] args){
        Thread.currentThread().setContextClassLoader(Sty026.class.getClassLoader());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() + ",laoder:" + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上线文类加载器；"+ Thread.currentThread().getContextClassLoader());
        System.out.println("serviceloader的类加载器：" + ServiceLoader.class.getClassLoader());

    }

    @Test
    public void test1(){
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() + ",laoder:" + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上线文类加载器；"+ Thread.currentThread().getContextClassLoader());
        System.out.println("serviceloader的类加载器：" + ServiceLoader.class.getClassLoader());

    }
}
