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
        if(index == str.length()-1){
            System.out.println(res);
            return;
        }

        printAllSubSeque(str,index+1,res + str.indexOf(index));//要
        printAllSubSeque(str,index+1,res);//不要
    }

    /**
     * 打印一个字符串的所有全排序结果
     */

    public void printAllPermutations(char[] chars,int index){
        int len = chars.length;
        if(index == len -1){
            System.out.println(chars);
            return;
        }
        for(int j=index;j < len;j++){
            swap(chars,index,j);
            printAllPermutations(chars,index+1);
        }

    }

    public void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;


    }

    /**
     * 母牛问题
     * 母牛每年生一只母牛，新出生的母牛成长后也能每年生一只母牛，假设不会死，求n年后，母牛的数量
     * f(n) = f(n-1) + f(n-3)
     * 第n年母牛的数量，等于 n-1年的数量，牛不会死，会并入n年，新增的牛是三年前出生的牛，
     * 这个时候会下新的牛，数量和三年前的数量 1:1
     */
}
