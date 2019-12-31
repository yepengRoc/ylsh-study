package com.ylsh.jvm.bytecode;

/**
 * 栈帧（stack frame）
 * 栈帧是一种帮助虚拟机执行方法调用于方法执行的数据结构。
 * 栈帧本身是一种数据结构，封装了方法的局部局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息。
 *
 * 通过出入栈来进行数据的操作
 * 3-2=1
 * 先把3压入栈
 * 把2压入栈
 * -号时弹出2 和 3 计算3-2=1
 * 然后把1压入栈
 * 数据在栈上存储在slot中。slot可以复用。
 *
 * 符号引用，直接引用
 * 有些符号引用是在类加载阶段或是第一次使用时就会转换为直接引用，这种转换叫做静态解析；另外一种符号引用则是在每次运行期
 * 转换为直接引用，这种转换叫做动态链接，这体现为java的多态性。
 *
 * 1 invokeinterface: 调用接口中的方法，实际上是在运行期决定的，决定到底调用实现改接口的哪个对象的特定方法。
 * 2 invokestatic:调用静态方法。
 * 3 invokespecial:调用自己的私有方法、构造函数（<init>）以及父类的方法。
 * 4 invokevirtual:调用虚方法，运行期动态查找的过程。
 * 5 invokedynamic:动态调用方法
 *
 * 静态解析的4中情形：
 * 1 静态方法
 * 2 父类方法
 * 3 构造方法
 * 4 私有方法（无法被重写）
 * 这4类方法称为非虚方法，是在类加载阶段就可以将符号引用转换为直接引用的。
 *
 *
 */
public class Sty004 {

    public static void main(String[] args) {
         int a = 3;
         if(a < 4){
             int b = 4;
             int c = 5;
         }
         int d = 7;
         int e = 8;

         test();
    }

    public  static void test(){
        System.out.println("test invoked");
    }
}
