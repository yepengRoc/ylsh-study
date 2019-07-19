package com.ylsh.study.jdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorSty {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer val = it.next();
//            it.remove();
            if(val == 3){
                it.remove();
                it.remove();
            }

        }
        System.out.println(list);
    }
}
