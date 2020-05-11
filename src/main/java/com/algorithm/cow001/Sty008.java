package com.algorithm.cow001;

/**
 * manachar 算法
 */
public class Sty008 {


    /**
     * 对string进行处理，在string中加入#
     * @param str
     * @return
     */
    public char[] manacherString(String str){
        char[] srcCharArr = str.toCharArray();

        char[] destCharArr = new char[srcCharArr.length+1];
        int len = destCharArr.length;
        for(int i = 0;i < len;i++){
            destCharArr[i] = i%2==0 ? '#' : srcCharArr[i/2];
        }
        return destCharArr;
    }
}
