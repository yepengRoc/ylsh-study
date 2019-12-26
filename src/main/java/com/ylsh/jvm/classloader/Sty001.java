package com.ylsh.jvm.classloader;

/**
 *对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕了
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 * -XX:+<option> 表示开启option选项
 * -XX:-<option>表示关闭opiton选项
 * -XX:<option>=<value> 表示将option选项的值设置为value
 * 对于默认开启的参数可以使用-XX:-关闭；对于默认关闭的参数可以使用-XX:+开启
 */
public class Sty001 {
    public static void main(String[] args) {
         System.out.println(Child001.cStr);
    }

}

class Parent001 {
    public static String pStr = "p hello";

    static{
        System.out.println("parent001 static block");
    }
}


class Child001 extends Parent001 {
    public static String cStr = "c hello";

    static{
        System.out.println("child001 static block");
    }
}
/***
 * ======================result==================
 * parent001 static block
 * child001 static block
 * c hello
 * ===========================================
 * 增加 vm参数-XX:+TraceClassLoading后查看
 * [Loaded Parent001 from file:/F:/ideaOpenSouceReposity/ylsh-study/target/classes/]
 * [Loaded Child001 from file:/F:/ideaOpenSouceReposity/ylsh-study/target/classes/]
 * [Loaded java.net.URI$Parser from D:\JavaInstallFiles\jdk1.8.0_144\jre\lib\rt.jar]
 * parent001 static block
 * child001 static block
 * c hello
 */
