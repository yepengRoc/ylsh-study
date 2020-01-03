package com.ylsh.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 通过cglib创建一个个的类数据
 * -XX:MaxMetaspaceSize=10M
 *
 * http://infoq.cn/article/Java-permgen-Removed
 */
public class Sty004 {

    public static void main(String[] args){

        while(true){
            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(Sty004.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, mehod, args1, proxy) ->{
                return proxy.invokeSuper(obj,args1);
            });
            System.out.println("cglib creat obj");
            enhancer.create();
        }

    }

    //图片 080630

}
