package com.ylsh.jvm.bytecode;

import javax.management.openmbean.CompositeDataInvocationHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Sty009 {

    public static void main(String[] args) throws Exception{

        System.getProperties().put("sum.misc,ProxyGenerator,saveGeneratedFile","true");


        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSuject(rs);

        Class<?> cls = rs.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);

        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());


    }
}
