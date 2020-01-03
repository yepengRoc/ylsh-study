package com.ylsh.jvm.bytecode;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *  Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
 *  查看源码发现：
 *   Class<?> cl = getProxyClass0(loader, intfs); //生成代理类的入口
 *          // If the proxy class defined by the given loader implementing
 *         // the given interfaces exists, this will simply return the cached copy;
 *         // otherwise, it will create the proxy class via the ProxyClassFactory
 *         return proxyClassCache.get(loader, interfaces);//真正生成代理类的地方，
 *         实际底层是通过ProxyClassFactory 的方法apply(ClassLoader loader, Class<?>[] interfaces)生成代理类
 *           //真正生成代理类的地方
 *          byte[]proxyClassFile=ProxyGenerator.generateProxyClass(proxyName,interfaces,accessFlags);
 *          在生成代码里有这么一个判断
 *          if(saveGeneratedFiles)//则将生成的代理类保存在本地文件系统中。
 *          通过设置系统属性sun.misc.ProxyGenerator.saveGeneratedFiles=true,来使生成的代理类保存到本地系统，
 *          反编译代理类
 *
 *
 */
public class Sty009 {

    public static void main(String[] args) throws Exception{
        //设置此属性，来使生成的代理类保存到本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");


        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSuject(rs);

        Class<?> cls = rs.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);

        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());




    }
}
/**
 *
 *代理类反编译类
 * package com.sun.proxy;
 *
 * import com.ylsh.jvm.bytecode.Subject;
 * import java.lang.reflect.InvocationHandler;
 * import java.lang.reflect.Method;
 * import java.lang.reflect.Proxy;
 * import java.lang.reflect.UndeclaredThrowableException;
 *
 * public final class $Proxy0 extends Proxy implements Subject {
 *     private static Method m1;
 *     private static Method m2;
 *     private static Method m3;
 *     private static Method m0;
 *      构造函数传入的是一个InvocationHandler 的子类。调用
 *     public $Proxy0(InvocationHandler var1) throws  {
 *         super(var1);//调用InvocationHandler 实现类的无参构造函数
 *     }
 *      //重写了equals
 *     public final boolean equals(Object var1) throws  {
 *         try {
 *             return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
 *         } catch (RuntimeException | Error var3) {
 *             throw var3;
 *         } catch (Throwable var4) {
 *             throw new UndeclaredThrowableException(var4);
 *         }
 *     }
 *      //重写了toString
 *     public final String toString() throws  {
 *         try {
 *             return (String)super.h.invoke(this, m2, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *     生成一个和被代理类一样的方法
 *     public final void request() throws  {
 *         try {
 *              调用代理类的invoke方法
 *             super.h.invoke(this, m3, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     public final int hashCode() throws  {
 *         try {
 *             return (Integer)super.h.invoke(this, m0, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     static {
 *         try {
 *              类初始化的时候获取代理类的m3 实际要调用的方法m3
 *             m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
 *             m2 = Class.forName("java.lang.Object").getMethod("toString");
 *             m3 = Class.forName("com.ylsh.jvm.bytecode.Subject").getMethod("request");
 *             m0 = Class.forName("java.lang.Object").getMethod("hashCode");
 *         } catch (NoSuchMethodException var2) {
 *             throw new NoSuchMethodError(var2.getMessage());
 *         } catch (ClassNotFoundException var3) {
 *             throw new NoClassDefFoundError(var3.getMessage());
 *         }
 *     }
 * }
 */

