package com.ylsh.study.thread.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerSty {

    public static void main(String[] args)  throws  Exception{
        Exchanger<String> exchanger = new Exchanger();

        String val = "afdasd";
        val = exchanger.exchange(val);
        String val2 = null;
        val2 = exchanger.exchange(val2);
    }
}
