package com.ylsh.jvm.classloader;



/**
 * 当前类加载器（current classloader）
 *
 * 每个类都会使用自己的类加载器（即加载自身的类加载器）去加载其它类（指的是所依赖的类）
 * 加载ClassX引用类ClassY,那么ClassX的类加载器就会去加载ClassY(前提是ClassY尚未被加载)
 *
 * 线程上下文加载器（context classloader）
 *
 * 线程上下文加载器是从jdk1.2引入的，类Thread中getContextClassLoader()和setContextClassLoader(ClassLoader c1)
 * 分别用来获取和设置上下文类加载器。
 *
 * 如果没有通过setContextClassLoader进行设置的话，线程将继承其父线程的上下文类加载器，java应用运行时的初始线程的上下文类加载器
 * 是系统类加载器。在线程中运行的代码可以通过该类加载器来加载类与资源。
 *
 * 线程上下文类加载器的重要性：
 * SPI: service provider interface
 * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classloader加载的类。
 * 这就改变了父ClassLoader不能使用子ClassLoader或是其它没有直接父子关系的ClassLoader加载类的情况，即改变类双亲委托模型。
 *
 * 线程上线文类加载器就是当前线程的Current ClassLoader
 *
 * 在双亲委托模型下，类加载器是由下至上的，即下层的类加载器会委托上层进行加载。但是对于SPI来说，有些接口是java核心类库所提供的，而
 * java核心库是由启动类加载器加载的，而这些接口的实现却来自于不同的jar包（厂商提供）。java启动类加载器是不会加载其它来源的jar包，
 * 这样的传统双亲委托模型就无法满足SPI的要求。而通过给当前线程设置上下文类加载器，就可以由设置的上线文类加载器来实现对于接口实现类的加载。
 */
public class Sty023 {

    public static void main(String[] args){

        System.out.println(Thread.currentThread().getContextClassLoader());
        //根类加载器
        System.out.println(Thread.class.getClassLoader());
    }
}
