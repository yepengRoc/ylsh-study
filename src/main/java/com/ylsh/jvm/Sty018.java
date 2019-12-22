package com.ylsh.jvm;

import org.junit.Test;

public class Sty018 {

    public static void main(String[] args){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

    /**
     * 删除当前classpath下的Sty001.class 则类加载器是loader1
     * 如果不删除，则类加载器是appclassloader
     * @throws Exception
     */
    @Test
    public void test() throws Exception{

        Sty016 loader1 = new Sty016("loader1");

        loader1.setPath("/Users/yexiaoheiheliunuannuan/Desktop");

        Class<?> clazz = loader1.loadClass("com.ylsh.jvm.Sty001");
        System.out.println("class:" + clazz.hashCode());
        System.out.println("class loader:" + clazz.getClassLoader());

    }
}
