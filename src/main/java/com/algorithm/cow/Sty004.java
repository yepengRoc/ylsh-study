package com.algorithm.cow;

/**
 * 归并排序
 * 把一个数组一分为2，分别对左右排序
 * 然后再把左右一分为2 ，再分别对左右排序
 * 以此类推
 *
 * 需要一个临时数组
 *
 * n1 n2 n3 n3
 */
public class Sty004 {



    public void mergeSort(int[] arr,int left,int right){
        if(null == arr || arr.length < 2){
            return;
        }
        int mid = right >> 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid +1,right);
        merge(arr,left,mid,right);
    }

    public void merge(int[] arr,int left,int mid,int right){
        int[] help = new int[right - left + 1];

        int i = 0;

        int p1 = left;
        int p2 = mid + 1;
        int sum = 0;
        while(p1 <= mid && p2 <= right){
//            help[i] = arr[p1] < arr[p2] ? arr[p1] : arr[p2];
            int small = 0;
            if(arr[p1] < arr[p2]){
                small = arr[p1];
                p1++;
                /**
                 * 求小和的时候，会用这一步，小和问题，这个时候，明显知道 右边比当前数大的数有几个
                 */
                sum = small * (right - p2 + 1);
            }else{
                small = arr[p2];
                p2++;
            }
            help[i] = small;
            i++;
        }
        while(p1 <= mid){
            help[i] = arr[p1];
            i++;
            p1++;
        }
        while(p2 <= mid){
            help[i] = arr[p2];
            p2++;
            i++;
        }
        for(i = 0;i< help.length;i++){
            arr[left + i] = help[i];
        }

        /**
         * 这个sum 可以返回。这个就是小和
         */

    }
}

//求一个数组的小和 之和
/**
 * 所谓小和 就是一个数 ，左边比这数小的数，都是这个数的小和
 *
 * 归并排序，在归并的过程中，可以很好的找到xiaohe
 */
