package com.algorithm.plastic;

/**
 * 遍历每一个数 插入到合适的位置
 */
public class DirectInsertSort {

    public static void sort(int[] arr){
        int len = arr.length;

        for(int i = 1;i< len;i++){
            for(int j = i-1;j>=0;j--){//为 arr[i] 在0 i-1找一个合适的位置
                if(arr[j] < arr[i]){//找到第一个比 arr[i] 小的数
                    break;
                }
                if(j != i-1){//如果等于i-1,则就不用移动了
                    int value = arr[i];
                    for(int k = i-1;k > j;k--){//整体后移
                        arr[k+1] = arr[k];
                    }
                    arr[j+1] = value;
                }
            }

        }
    }
}
