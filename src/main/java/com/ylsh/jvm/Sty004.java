package com.ylsh.jvm;

import org.springframework.test.annotation.SystemProfileValueSource;

/**
 * 数组实例的类型是在运行期动态生成的，表现形式[Lcom.ylsh.jvm.Parent004。
 * 动态生成的类型的父类型为Object
 * java文档经常将构成数组的元素称为Component,即数组降低一个维度后的类型
 *
 * javap -c Sty004.class  查看反编译代码
 * 助记符：
 * anewarray:表示创建一个引用类型（如：类 接口 数组）的数组，并将其引用值压入栈顶
 * newarray:表示创建一个指定的原始类型的数组（如int  float），并将其值压入栈顶
 *
 *
 */
public class Sty004 {

    public static void main(String[] args){
        /**
         * 静态代码块只会被执行一次
         */
        Parent004 p1 = new Parent004();

        Parent004 p2 = new Parent004();
        System.out.println("===========");
        Parent004[] pArr = new Parent004[1];
        System.out.println(pArr.getClass());
        System.out.println(pArr.getClass().getSuperclass());

        Parent004[][] pArr2 = new Parent004[1][1];
        System.out.println(pArr2.getClass());
        System.out.println(pArr2.getClass().getSuperclass());

        System.out.println("======");

        int[] iArr = new int[1];
        System.out.println(iArr.getClass());
        System.out.println(iArr.getClass().getSuperclass());

        char[] cArr = new char[1];
        System.out.println(cArr.getClass());
        System.out.println(cArr.getClass().getSuperclass());

        boolean[] bArr = new boolean[1];
        System.out.println(bArr.getClass());
        System.out.println(bArr.getClass().getSuperclass());

        short[] sArr = new short[1];
        System.out.println(sArr.getClass());
        System.out.println(sArr.getClass().getSuperclass());

        byte[] btArr = new byte[1];
        System.out.println(btArr.getClass());
        System.out.println(btArr.getClass().getSuperclass());


    }
}

class Parent004{
    static {
        System.out.println("static code");
    }
}
/**
 * static code
 * ===========
 * class [Lcom.ylsh.jvm.Parent004;
 * class java.lang.Object
 * class [[Lcom.ylsh.jvm.Parent004;
 * class java.lang.Object
 * ======
 * class [I
 * class java.lang.Object
 * class [C
 * class java.lang.Object
 * class [Z  因为byte类型使用类B所以这里定义类一个Z作为布尔类型
 * class java.lang.Object
 * class [S
 * class java.lang.Object
 * class [B
 * class java.lang.Object
 */
