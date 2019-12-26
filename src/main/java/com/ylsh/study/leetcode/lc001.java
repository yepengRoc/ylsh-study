package com.ylsh.study.leetcode;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加等于9
 * 返回给定数组中两数相加等于9的索引
 * 数组限制：
 * 如果有的话，只有一对结果，
 */
public class lc001 {

    public int[] twoSum(int[] arr){


        if(null == arr || arr.length < 1){
            return new int[]{-1,- 1};
        }
        int target = 9;

        int arrLen = arr.length;
        Map<Integer, Integer> arrMap = new HashMap<>(arrLen);
        for(int i = 0 ;i < arrLen;i++){
            if(arrMap.containsKey(target - arr[i])){
                return new int[]{arrMap.get(target - arr[i]),i};
            }
            arrMap.put(arr[i], i);
        }
        return new int[]{-1,- 1};

    }
}
