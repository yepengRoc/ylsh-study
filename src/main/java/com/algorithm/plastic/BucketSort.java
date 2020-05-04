package com.algorithm.plastic;

/***
 * 桶排序
 * 把每个数字都看成一个桶.
 * 根据数组中元素的最大值，建立一个数组
 *
 * 如果数据不连续，则占用空间较大。中间都是空出来的
 */
public class BucketSort {

    public static void sort(int[] arr){
        if(null == arr || arr.length < 1){
            return;
        }
        int len = arr.length;
        int maxVal = arr[0];
        for(int i= 1; i< len;i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        int[] tmpArr = new int[maxVal + 1];
        for(int i= 0; i< len;i++){
            if(arr[i] > maxVal){
                tmpArr[arr[i]]++;
            }
        }
        int temArrLen = tmpArr.length;
        int i = 0;
        for(int j=0 ;j<temArrLen; j++){
            while(tmpArr[j] > 0){
                arr[i] = j;
                i++;
                tmpArr[j]--;
            }
        }

     }
}
