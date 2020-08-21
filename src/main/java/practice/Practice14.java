package practice;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 为了解决回文子串问题
 * manachers */
public class Practice14 {


    public static void main(String[] args) throws Exception{
        System.out.println(Integer.numberOfLeadingZeros(16));
        System.out.println(1 << (16 - 1));
        int rst = Integer.numberOfLeadingZeros(16) | (1 << (16 - 1));
        System.out.println(rst);
    }

    /**
     * 回文半径
     * 回文半径数组  保存每个字符的回文半径  包括回文中心
     * 最右边界
     * 最右回文边界对应的回文中心
     *
     * 最长回文子串
     */

    /**
     * 分类讨论
     * 如果是奇数  则有一个回文中心
     * 偶数的话会导致没有回文中心
     * 需要对字符串进行处理
     */

    public char[] manacherString(String str){
        char[] charArr = str.toCharArray();

        char[] rtnArr = new char[2*charArr.length+1];
        for(int i = 0;i < charArr.length;i++){
            rtnArr[i] = i%2 == 0 ? '#' : charArr[i/2];
        }
        return rtnArr;
    }


    public int maxLen(String str){
        char[] sourArr = manacherString(str);
        //辅助数组。
        int[] pArr = new int[sourArr.length];
        int R = -1;//最右回文边界
        int C = -1; //回文中心
        int max = Integer.MIN_VALUE;
        for(int i=0;i < sourArr.length;i++){
            /**
             * i 就是cur
             * 当在 最右边界的右边时
             *
             * 如果在左边的话，取对称点 和 R-i哪个小取哪个。然后外扩
             */
            pArr[i] = i > R ? 1 : Math.min(pArr[C*2 - i],R - i);

            while(i + pArr[i] < sourArr.length && i - pArr[i] > -1){
                if(i+pArr[i] == i - pArr[i]){//继续外扩
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(R < i+pArr[i]){
                R = i+pArr[i] -1;//确定最右边界
            }
            max = Math.max(max,pArr[i]);
        }
        return max -1;//最长回文子串。会多一个#
    }

}
