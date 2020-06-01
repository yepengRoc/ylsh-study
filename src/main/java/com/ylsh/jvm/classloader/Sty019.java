package com.ylsh.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class Sty019 {

    public static void main(String[] args){
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(Sty019.class.getClassLoader());
    }
}
/**
 * sun.misc.Launcher$ExtClassLoader@2d98a335
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 *
 * 这里通过修改ext 扩展jar包的路径,并编译类，来查看Sty019类的类加载器是否改变
 * java -Djava.ext.dir = ./  Sty019
 * java -Djava.ext.dir = ./
 *
 * 还有一种操作，把当前类打成jar包放到ext目录下，再次执行代码，查看sty019对应的类加载器
 *
 */
