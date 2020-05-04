package com.algorithm.cow;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

/**
 * 堆。 排序
 * 这里构建一个大根堆
 */
public class Sty017 {



    public void heapInsert(int[] arr,int index,int value){

        arr[index] = value;

        while(index > 0){
            int parentIndx = index/2;

            if(arr[index] > arr[parentIndx]){
                //更换 index 和parentIndex的值
            }
            index = parentIndx;
        }
    }

    void heapify(int[] arr,int heapSize,int index){
        int left = 2*index+1;

        while(left < heapSize){
            /**
             * 求左右孩子的最大节点
             */
            int right = left+1;

            int greatValIndex = right < heapSize && arr[left] < arr[right] ? right:left;
            greatValIndex = arr[greatValIndex] > arr[index] ? greatValIndex : index;
            if(greatValIndex == index){
                return;
            }
            //交换 greatIndex 和 index位置的值
            index = greatValIndex;
            left = index*2 + 1;
        }
    }

    void heapSort(int[] arr){
        int[] heapArr = null;//把 arr构建成一个大根堆

        int len = heapArr.length;

        /**
         * 交换 0 和 len-1位置的值
         */
        while(len > 0){
            len--;
            heapify(heapArr,len,0);
            /**
             * 再次交换 0 到 len-1位置的值
             */
        }


    }
}
