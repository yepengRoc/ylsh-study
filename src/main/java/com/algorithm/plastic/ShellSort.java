package com.algorithm.plastic;

public class ShellSort {
    //跟直接排序相似。不过要选定步长
    public static void sort(int[] arr){
        int len = arr.length;

        for(int step = len/2;step > 0;step = step/2){
            for(int i = 0; i< step;i++){
                for(int j = i+ step;j< len; j = j+step){
                    if(arr[j-step] < arr[j]){
                        int value = arr[j];
                        int k = j - step;
                        while(k >= 0&&arr[k]> value){
                            arr[k+step] = arr[step];
                        }
                        arr[k+step] = value;
                    }
                }
            }
        }

    }
}
