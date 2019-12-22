package com.ylsh.jvm;

import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import sun.jvm.hotspot.tools.SysPropsDumper;

public class MyCat {

    public MyCat(){
        System.out.println("mycat is loader by :" + this.getClass().getClassLoader());

        System.out.println("from mycat :" + MySample.class);
    }
}
