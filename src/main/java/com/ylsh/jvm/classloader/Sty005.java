package com.ylsh.jvm.classloader;

import java.util.Random;

/**
 * 接口初始化时，不要求其父接口已经完成了初始化。
 * 只有在真正调用父接口的时候（如引用接口中的常量），才会初始化
 *
 * 这里其实只是因为 final的原因，并不能说明接口的初始问题
 */
public class Sty005 {

    public static void main(String[] args){
        System.out.println(Child005.b);
    }
}

/**
 * 接口中的变量默认是public static final类型
 */

interface Parent005 {
    int a = new Random().nextInt(5);

}

interface Child005 extends Parent005{
    int b = 5;
}