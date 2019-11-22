package com.ylsh.study.thread.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapSty {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        //there is not any support for locking the entire table in a way that prevents all access.
        map.put("a", "adfads");
    }
}
