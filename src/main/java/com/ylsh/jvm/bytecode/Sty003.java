package com.ylsh.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * 对于java类中的每一个实例方法（非static方法），其在编译后所生成的字节码当中，方法参数的数量总是比
 * 源代码中方法参数的数量多一个（this）,它维护方法的第一个参数位置处；这样，我们就可以在java的实例
 * 方法中使用this来访问当前对象的属性以及其它方法。
 * 这个操作是在编译期间完成的，即由java编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的
 * 访问；接下来在好运行期间，由jvm在调用实例方法时，自动向实例方法传入该this参数，所以，在实例方法
 * 的局部变量中，至少由一个指向当前对象的局部变量
 *
 *
 * java字节码对于异常的处理方式：
 * 1统一采用异常表的方式来对异常进行处理
 * 2在jdk1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式。
 * 3当异常处理存在finally语句块是，现代化的jvm采取的处理方式是将finally语句块的自己吗拼接到
 * 每一个catch块后面。即程序中有多少个catch块，就有多少个finally语句块。
 */
public class Sty003 {

    public void test(){
        try {
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket();
            serverSocket.accept();
        } catch (FileNotFoundException ex){

        }catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){

        }finally {
            System.out.println("finally");
        }

    }
}
