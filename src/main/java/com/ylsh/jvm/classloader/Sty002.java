package com.ylsh.jvm.classloader;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类，因为并不会触发定义常量的类的初始化。
 * 注意：这里指的是将常量存放到了Sty002的常量池中，之后Sty002与Parent002就没有任何关系了，
 * 如果我们将编译好的Parent002.class文件删除，程序也可正常执行，无任何影响
 * 通过javap -c Sty002.class 查看对应的助记符
 * idc表示将 int ,float或是String类型的常量从常量池中推送至栈顶
 * bipush 表示将单个字节（-128-127）的常量推送至栈顶
 * sipush 表示将一个短整型常量（-32768-32767）推送至栈顶
 * iconst_1标识将int类型1推送至栈顶(iconst-1 至 iconst5 )
 * 查看ICONST类 只标识 -1 到 5 的常量
 *  * ICONST - Push value between -1, ..., 5, other values cause an exception
    public class ICONST extends Instruction
 *implements ConstantPushInstruction,TypedInstruction
 * 其它雷同，都有对应的类
 */
public class Sty002 {
    public static void main(String[] args) {
         System.out.println(ParentOO2.i);
        System.out.println(ParentOO2.m);
        System.out.println(ParentOO2.s);
        System.out.println(ParentOO2.str);
    }
}

class ParentOO2 {
    public static final String str = "hello";

    public static final short s = -127;

    public static final int i = -1;

    public static final int m = 6;

    static{
        System.out.println("p002 static block");
    }
}
/**
 * =============javap -c Sty002.class 反编译结果
 * public class Sty002 {
 *   public Sty002();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: iconst_m1
 *        4: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
 *        7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       10: bipush        6
 *       12: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
 *       15: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       18: bipush        -127
 *       20: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
 *       23: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       26: ldc           #5                  // String hello
 *       28: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       31: return
 * }
 */