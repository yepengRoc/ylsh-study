package com.algorithm.cow;

/**
 * 快排，快排的思想。 有点像归并
 * 左右排，选定一个中间数，然后分成左右，小于这个数，放左边
 * 大于这个数放右边
 *
 */
public class Sty006 {


    public static void quickSort(int[] arr,int left,int right){

        if(left < right){
            /**
             * 这里使用随机算法，使得最后一个的数据变化
             * 因为这的参考是最后一位，这里的参考值越随机，越有利于排序
             * 假设对一个 有序数组 进行 快排 1 2 3 4  5 6 7
             * 只有左边没有右边，这个最没有效率，通过随机打乱数组中数的顺序提高效率
             */
            swap(arr,left + (int)(Math.random()*(right-left+1)),right);//这里使用随机算法，使最后以
            int[] temArr = partition(arr,left,right);
            quickSort(arr,left,temArr[0] -1);
            quickSort(arr,temArr[1]+1,right);

        }
    }

    public static int[] partition(int[] arr,int left,int right){//这里的arr[right]为参考数

        int less = left -1;
        int more = right;
        int canKaoVal = arr[right];

        while(left < more){
            if(arr[left] < arr[right]){//相等的时候。代码没有推进
                less++;
                swap(arr,less,left);
                left++;
            }else if(arr[left] > arr[right]){
                more--;
                swap(arr,left,more);
            }else{//相等也要推进指针前进
                left++;
            }
        }
        //swap(arr,more,right);//more位置上肯定都是大于 arr[right]的数。所以把 arr[right]放到一个中间的位置
        return new int[]{less+1,more};//返回中间相等数据的起始 和结束位置，这些数据不用再排序了

    }

    public static  void swap(int[] arr,int a,int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[a];
        arr[a] = arr[a] ^ arr[b];
    }
}
