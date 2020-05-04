package com.algorithm.cow;

/**
 * 给定一个数组。求排序后相邻两数的最大差值
 *
 *
 *
 */
public class Sty018 {



    int getMaxGap(int[] arr,int bulkNum){

        int[] mins = new int[bulkNum+1];//用来记录每个桶中的最小数

        int[] maxs = new int[bulkNum+1];//用来记录每个桶中的最大数

        boolean[] bs = new boolean[bulkNum+1];//用来记录每个桶中是否有数

        int maxVal = arr[0];
        int minVal = arr[0];
        for(int i = 0;i < bulkNum; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
            if(arr[i] < minVal){
                minVal = arr[i];
            }
        }
        for(int i = 0;i < bulkNum; i++){
            int bulkIndex = (arr[i] - minVal) * bulkNum/(maxVal - minVal);
            bs[bulkIndex] = true;
            if(maxs[bulkIndex] < arr[i]){
                maxs[bulkIndex] = arr[i];
            }
            if(mins[bulkIndex] > arr[i]){
                mins[bulkIndex] = arr[i];
            }
        }
        int rst = 0;
        for(int j=0;j < bulkNum;j++){
            if(!bs[j]){
                continue;
            }
            int val1 = maxs[j];
            while(!bs[++j]){
            }
            int val2 = mins[j];
            rst = Math.max(rst,val2 - val1);

        }


        return rst;

    }



}
