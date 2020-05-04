package com.algorithm.cow;

/**
 * kmp算法。如果某一个字符不匹配，则找这个字符前面的 数据的最长前缀和最长后缀的公共部分
 *
 * 最长前缀不包含最后一个字符
 * 最长后缀不包含第一个字符
 *
 */
public class Sty014 {

    /**
     * 求解 match如果在string中可以匹配到，返回str匹配上的第一个字符的索引
     * @param str
     * @param match
     * @return
     */
    int getIndexOf(String str,String match){
        if(null == str || null == match){
            return -1;
        }
        if(match.length() > str.length()){
            return -1;
        }

        int strLen = str.length();
        int matchLen = match.length();
        char[] strChar = str.toCharArray();
        char[] matchChar = match.toCharArray();
        /**
         * help辅助数组，对应matchchar中每个字符的 最长前缀和最长后缀的公共部分
         */
        int[] help = new int[matchLen];

        int i = 0;
        int j = 0;
        while(i < strLen && j < matchLen){
            if(strChar[i] == matchChar[j]){
                i++;
                j++;
            }else if(strChar[i] != matchChar[j]){
                /**
                 * 这里辅助数组的第一个字符的前缀和后缀 公共部分的值定义Wie-1
                 */
                if(help[j] != -1){//直接修改match指针到 最长前缀后缀公共部分，前缀公共部分结束的位置
                    j = help[j];
                }else{//说明 辅助数组的项等于-1，说明是匹配数组的第一个位置，如果不匹配则移动 str中的位置，找第一个和match中第一个字符匹配的位置
                    i++;
                }
            }
        }
        /**
         * 如果 j移动完了，最后匹配上了，j也移动完了
         */
        return j ==matchLen ? i - matchLen : -1;

    }
    /**
     * 获取辅助数组
     */
    int[] getHelper(char[] match){

        int len = match.length;
        int[] help = new int[len];
        help[0] = -1;
        help[1] = 0;
        int i = 2;
        int cn = 0;
        while(i < len){
            if(match[cn] == match[i-1]){
                i++;
                cn++;
                help[i] = help[i-1]+1;
            }if(help[cn] == -1){//说明到头了都没有 前缀和后缀的匹配部分
                help[i] = 0;
                i++;
                cn++;//继续
            }else{//没有到头
                cn = help[cn];//如果前面没有匹配上，则让cn 回到 helper[cn]记录的最长前缀的公共部分的位置，重复上面的过程
            }
        }

        return help;
    }
}
