package com.ylsh.jvm.classloader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * 如果系统只有一个数据库驱动，则不需要写System.getProperty("jdbc.drivers")
 * 如果系统中一个以上的驱动，则需要写System.getProperty("jdbc.drivers")
 * 例如既有mysql 又有oracal
 * 进行源码分析
 */
public class Sty027 {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
     //   driver.

        System.out.println(System.getProperty("jdbc.drivers"));

        Connection conn = DriverManager.getConnection("jdbc://locahost:3306/coredb", "usrname", "password");
    }
}
//进行源码分析
