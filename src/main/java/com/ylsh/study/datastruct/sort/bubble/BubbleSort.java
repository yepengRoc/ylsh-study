package com.ylsh.study.datastruct.sort.bubble;
/**
 * 冒泡排序
 * @author YePengPeng
 * 
 * 大的水泡会上浮。
 *
 */
public class BubbleSort {
	
	public static void sort(int[] arr){
		
		int len = arr.length;
		
		for(int i = len -1 ; i > 0; i--){
			int max = arr[0];//每次循环 都要初始化
			int maxIdx = 0;
			for(int j = 0 ; j <= i;j ++){
				if(arr[j] > max){
					max = arr[j];
					maxIdx = j;
				}
			}
			if(i == maxIdx){//如果没有发生交换，说明 数组已经有序。
				break;
			}
			swap(arr,i,maxIdx);
		}
	}
	/**
	 * 交换数组中 两个位置的数量
	 * @param arr
	 * @param aIdx
	 * @param bIdx
	 * 
	 * 使用异或特性进行数据交换 。 一个数连续两次异或另外一个数，还是等于自己
	 */
	public static void swap(int[] arr,int aIdx,int bIdx){
		//判断两个位置是否超出下标
		//...
		arr[aIdx] = arr[aIdx]^arr[bIdx];
		arr[bIdx] = arr[aIdx]^arr[bIdx];
		arr[aIdx] = arr[aIdx]^arr[bIdx];
	}

}
