package com.algorithm.cow;

public class Sty016 {


    int[] partition(int[] arr,int left,int right){

        int less = left -1;
        int great = right + 1;
        int value = arr[right];
        while(left <= right){
            if(arr[left] < arr[right]){
                less++;
                /**
                 * 更换 arr[less] 和arr[left] 位置的值
                 */
                left++;
            }else if(arr[left] > arr[right]){
                /**
                 * 更换 arr[left] 和 arr[left]的值
                 *
                 */
                right--;
            }else{
                left++;//这个时候lessmeiy没有推进
            }
        }
        return null;

    }

    void quicksort(int[] arr,int left,int right){

        int[] rst = partition(arr,left,right);
        quicksort(arr,left,rst[0]-1);
        quicksort(arr,right,rst[1]+1);

    }


}
