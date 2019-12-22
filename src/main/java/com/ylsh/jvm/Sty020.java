package com.ylsh.jvm;

import org.junit.Test;

import java.lang.reflect.Method;

public class Sty020 {
    /**
     * 没有问题
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Sty016 loader1 = new Sty016("loader1");
        Sty016 loader2 = new Sty016("loader2");

        Class<?> clazz1 = loader1.loadClass("com.ylsh.jvm.MyParent");
        Class<?> clazz2 = loader2.loadClass("com.ylsh.jvm.MyParent");


        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setParent", Object.class);
        method.invoke(object1, clazz2);


    }

    /**
     * 抛异常类，因为loader1 和loader2是不同的命名空间，互相隔离。所以loader1找不到object2
     * @throws Exception
     * 类加载器双亲委托模型的好处：
     * 1可以确保java核心库的类型安全：所有的java应用都至少会引用java.lang.Object类，也就是说在运行期，java.lang.Object这个类
     * 会被加载到java虚拟机中；如果这个加载过程是由java应用自己的类加载器所完成的，那么很有可能会在jvm中存在多个版本的java.lang.Object
     *类，而且这些类之间还是不兼容的，互相不可见（命名空间的作用）。借助于双亲委托机制，java核心类库中的类的加载都是由启动类加载器统一加载，
     * 从而确保java应用所使用的都是同一个版本的java核心类库，他们之间是互相兼容。
     * 2 可以确保java核心类库所提供的类不会被自定义的类所替代。
     * 3 不同的类加载器可以为同名称（binary name）的类创建额外的命名空间。相同的类可以并保存在java虚拟机中，只要用不同的类加载器
     * 加载即可，不同类加载器所加载的类是互相不兼容的，相当于java虚拟机创建类一个又一个互相隔离的java类空间，这类技术在很多框架中
     * 得到类实际应用。
     *
     */
    @Test
    public void test() throws Exception{
        Sty016 loader1 = new Sty016("loader1");
        Sty016 loader2 = new Sty016("loader2");

        loader1.setPath("/Users/yexiaoheiheliunuannuan/Desktop");
        loader2.setPath("/Users/yexiaoheiheliunuannuan/Desktop");

        Class<?> clazz1 = loader1.loadClass("com.ylsh.jvm.MyParent");
        Class<?> clazz2 = loader2.loadClass("com.ylsh.jvm.MyParent");


        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setParent", Object.class);
        method.invoke(object1, object2);
    }
}
