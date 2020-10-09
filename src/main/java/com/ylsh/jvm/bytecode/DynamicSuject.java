package com.ylsh.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicSuject implements InvocationHandler {

    private Object sub;

    public DynamicSuject(Object object){
        this.sub = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before calling:" + method);
        method.invoke(this.sub, args);
        System.out.println("after calling:" + method);
        return null;
    }

   /* public static void main(String[] args) {
        Proxy proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),Subject.class,)
    }*/
}
