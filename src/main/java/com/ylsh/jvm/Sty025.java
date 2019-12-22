package com.ylsh.jvm;

public class Sty025 {
    /**
     * 线程上下文加载器的一般使用模式（获取-使用-还原）
     *   ClassLoader classLoader = this.thread.getContextClassLoader();
     *
     *         try {
     *             Thread.currentThread().setContextClassLoader(targetTccl);
     *             myMethod();
     *         } catch (Exception e) {
     *             Thread.currentThread().setContextClassLoader(classLoader);
     *         }
     *         myMethod里面调用类Thread.currentThread().getClassLoader(),获取当前线程上下文类加载器做某些事情。
     *         如果一个类有类加载器A加载，那么这个类的依赖也是由相同的类加载器加载的（如果该类之前没有被加载过的话）
     *         ContextClassLoader的作用就是为类破坏java的类加载委托机制。
     *         当高层提供了统一的接口让底层去实现，同时又要在高层加载（或实例化）底层类时，就必须要通过线程上下文类加载器
     *         来帮助高层的ClassLoader找到并加载该类。
     * @param args
     */
    public static void main(String[] args){
//        ClassLoader classLoader = this.thread.getContextClassLoader();
//
//        try {
//            Thread.currentThread().setContextClassLoader(targetTccl);
//            myMethod();
//        } catch (Exception e) {
//            Thread.currentThread().setContextClassLoader(classLoader);
//        }

    }
}
