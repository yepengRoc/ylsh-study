package com.ylsh.jvm;

/**
 * 把sty021打成jar包放入到java.ext.dirs目录中。再次执行以下代码。发现sty021的类加载变成了extclassloader
 * jar cvf test.jar com/ylsh/jvm/Sty021
 */

public class Sty021 {

    static {
        System.out.println("sty021 init");

    }

    public static void main(String[] args){
        System.out.println(Sty021.class.getClassLoader());

        System.out.println(Sty001.class.getClassLoader());
    }
}
