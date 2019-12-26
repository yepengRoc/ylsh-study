package com.ylsh.jvm.classloader;

import org.junit.Test;
import sun.misc.Launcher;

/**
 * 设置根类目录为当前
 * Java -Dsun.boot.class.path=./ Sty022
 * 这里会失败，因为java.lang.Object不在当前路径下
 */
public class Sty022 {

    public static void main(String[] args){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

    /**
     * 指定系统类加载器，并加载类Sty022
     * java -Djava.system.class.loader=com.lysh.jvm.Sty016 Sty022
     *
     * 默认的系统类加载器是appclassloader
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception{
        /**
         * 启动类加载器并不是java类，而其它类加载器都是java类
         * 启动类加载器是特定于平台的机器指令，它负责开启整个加载过程，
         *
         * 所有类加载器（除了启动类加载器）都被实现为java类，不过，总归要有一个组件来加载第一个类加载器，从而让整个加载过程能够被
         * 顺利进行下去，加载第一个java类加载器是启动类加载器的职责。
         *
         * 启动类加载器还会负责加载供jre正常运行的基本组件，这包括java.util 和java.lang包中的类等等
         */
        System.out.println(ClassLoader.class.getClassLoader());
        //扩展类加载器和系统类加载器也是由启动类加载器加载的。
        System.out.println(Launcher.class.getClassLoader());

        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(Sty022.class.getClassLoader());
        System.out.println(Sty016.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());


    }
}
