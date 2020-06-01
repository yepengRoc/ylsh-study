package com.ylsh.jvm.classloader;

import org.junit.Test;

public class Sty017 {

    public static void main(String[] args) throws Exception{

        Sty016 loadere1 = new Sty016("loader1");

        Class<?> clazz = loadere1.loadClass("com.ylsh.jvm.classloader.MySample");

        System.out.println("class:"+ clazz.hashCode());

        /**
         * 如果注释掉此行，那么并不会实例化MySample对象。所以MyCat也不会实例化，即MyCat没有
         * 被主动使用，所以也不会加载MyCat的class
         */
        Object object = clazz.newInstance();
    }

    /**
     * 将mysample拷贝到桌面一份
     * 这里测试在MyCat里加入打印MySample.class的代码.执行结果报错，calssnot found
     *
     * 这里因为MySample是被自定义加载器loader1加载的。
     * 而MyCat是被应用类加载器AppClassLoader加载的。
     * appclassloader是自定义类加载器的父类。
     * 故得出jvm命名空间的结论：
     * 1子加载器所加载的类都能访问父加载器加载的类
     * 2父加载器加载类无法访问子加载器加载的类
     *
     *
     * @throws Exception
     */

    @Test
    public void test() throws  Exception{
        Sty016 loader1 = new Sty016("loader1");

        loader1.setPath("/Users/yexiaoheiheliunuannuan/Desktop");

        Class<?> clazz = loader1.loadClass("com.ylsh.jvm.classloader.MySample");

        System.out.println("class:"+ clazz.hashCode());

        /**
         * 如果注释掉此行，那么并不会实例化MySample对象。所以MyCat也不会实例化，即MyCat没有
         * 被主动使用，所以也不会加载MyCat的class
         */
        Object object = clazz.newInstance();
    }
}
