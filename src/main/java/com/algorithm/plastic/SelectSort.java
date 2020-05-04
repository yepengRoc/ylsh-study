package com.algorithm.plastic;

public class SelectSort {

    //从剩下的 数中选取最小的数--跟冒泡排序差不多
    public static void sort(int[] arr){

        int len = arr.length;
        for(int i = 0;i< len;i++){
            int min = i;
            for(int j = i+1;j< len;j++){
                if(arr[j] < arr[j]){
                    min = j;
                }
            }
            if(i != min){//
                int tmpVal = arr[i];
                arr[i] = arr[min];
                arr[min] = arr[i];
            }
        }

    }

    public static void main(String[] args) {

    }
}
