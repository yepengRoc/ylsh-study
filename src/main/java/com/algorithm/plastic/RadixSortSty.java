package com.algorithm.plastic;

public class RadixSortSty {

    public static void sort(int[] arr){
            if(null == arr || arr.length < 1){
                return;
            }
            int maxVal = arr[0];
            int arrLen = arr.length;
            for(int i=1;i< arrLen;i++){
                if(arr[i] > maxVal){
                    maxVal = arr[i];
                }
            }

            for(int i = 1;i < maxVal;i = i*10){

                int[] outArr = new int[arr.length];
                int[] bucketArr = new int[10];

                for(int j =0 ;j< arrLen;j++){
                    int index = arr[j]/i % 10;
                    bucketArr[index]++;
                }
                int buckArrLen = bucketArr.length;
                for(int k = 1;k < buckArrLen;k++){
                    bucketArr[k] = bucketArr[k] + bucketArr[k-1];
                }

                for(int j =0 ;j< arrLen;j++){
                    int index = arr[j]/i % 10;
                    outArr[bucketArr[index] -1] = arr[j];
                    bucketArr[index]--;
                }
               /* arr = outArr;
                outArr = null;*/

                for(int k = 0;k<arrLen;k++){
                    arr[k] = outArr[k];
                }
                outArr = null;

            }

    }
}
