package com.algorithm.sort;

import java.util.List;

/**
 * 冒泡排序。想象下冒泡，大的气会往上浮
 * 算法稳定性，就不会变两个
 * 算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的！
 */
public class BubbleSort {


    public void sort(int[] arr){
        if(null == arr || arr.length <= 1){
            return;
        }
        int len = arr.length;
        for(int i=0;i< len;i++){
            int smallIndex = i;
            for(int j=i+1;j<len;j++){
                if(arr[j] < arr[i]){
                    smallIndex = j;
                }
            }
            //只有在确定最小值得时候，才进行交换
            if(smallIndex != i){
                int temp = arr[i];
                arr[i] = arr[smallIndex];
                arr[smallIndex] = temp;
            }
        }
    }

    public void Test(){
        Object
    }
}
