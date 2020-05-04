package com.algorithm.cow;

/**
 * 插入排序
 *
 *  选择一个数，进行比较。
 *  思想是取第一个数 a1 进行排序，
 *  取第二个数 a2 在已经有序的 a1中找到自己的位置放入
 *  取第三个数 a3 在已经有序的 a1 a2 中找到自己的位置放入
 *  以此类推
 */
public class Sty003 {

    public static void main(String[] args) {
        int[] arr  = new int[]{3,5,7,8,2,1,34,89,31};
        insertSort(arr);
        int len = arr.length;
        for(int i=0;i< len;i++)
            System.out.println(arr[i]);
    }

    public static void insertSort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }

        int len = arr.length;

        for(int i = 0; i< len; i++){

            int j = i;
            int tmp = arr[i];
            while(j > 0 && tmp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            };
            arr[j] = tmp;

        }
    }
}
