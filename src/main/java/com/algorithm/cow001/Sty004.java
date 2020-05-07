package com.algorithm.cow001;

public class Sty004 {

    /**
     * 汉诺塔问题
     */

    /**
     * 打印一个字符串所有的子序列
     *
     * 每个字符有两种情况 要或者不要
     */

    public void printAllSubSeque(String str,int index,String res){
        if(index == str.length()){
            System.out.println(res);
            return;
        }

        printAllSubSeque(str,index+1,res + str.indexOf(index));//要
        printAllSubSeque(str,index+1,res);//不要
    }
}
