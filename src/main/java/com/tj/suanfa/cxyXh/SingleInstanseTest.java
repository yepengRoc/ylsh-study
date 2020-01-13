package com.tj.suanfa.cxyXh;

import org.junit.Test;

public class SingleInstanseTest {

    @Test
    public void test1() {
        //getDeclaredConstructor
//        Constructor con = LazySingleInstanceInner.class.getConstructor(null);
//        Constructor<LazySingleInstanceInner> con = LazySingleInstanceInner.class.getDeclaredConstructor(null);
//        con.setAccessible(true);
//        LazySingleInstanceInner sg1 = con.newInstance();


    }

    /**
     * 对枚举反射的时候会报错
     */
    public void test2() {
        //getDeclaredConstructor
//        Constructor con = LazySingleInstanceInner.class.getConstructor(null);
//        Constructor<LazySingleInstanceInner> con = LazySingleInstanceInner.class.getDeclaredConstructor(null);
//        con.setAccessible(true);
//        LazySingleInstanceInner sg1 = con.newInstance();


    }
}
