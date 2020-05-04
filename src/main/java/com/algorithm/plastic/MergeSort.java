package com.algorithm.plastic;

/**
 * 归并排序
 *  由上到下
 *      先把数据拆分为各一半  接着拆
 *
 *  由下到上
 *
 *
 */
public class MergeSort {

   public static void sort(){

   }

   public static void down2Up(int[] arr){

      int arrLen = arr.length;

      for(int i = 1;i < arrLen;i= i*2){

         int step = 2*i;
         int j;
         for(j = 0;j+2*step -1 < arrLen;j=j+2*step){
            merge(arr,j,j+step-1,j+2*step-1);
         }
         /**
          * 如果还剩余一组
          */
         if(j+step - 1 < arrLen){
            merge(arr,j,j+step-1,arrLen-1);
         }

      }
   }

   public static void merge(int[] arr,int start,int mid,int end){

      int[] tmpArr = new int[end-start+1];

      int leftStart = start;
      int rightStart = mid + 1;

      int idx = 0;

      while (leftStart <= mid && rightStart <= end){
         if(arr[leftStart] <= arr[rightStart]){
            tmpArr[idx] = arr[leftStart];
            leftStart++;
         }else{
            tmpArr[idx] = arr[rightStart];
            rightStart++;
         }
         idx++;
      }
      while(leftStart <= mid){
         tmpArr[idx] = arr[leftStart];
         idx++;
         leftStart++;
      }
      while (rightStart <= end){
         tmpArr[idx] = arr[rightStart];
         idx++;
         rightStart++;
      }
      int arrLen = tmpArr.length;
      for(int k = 0;k< arrLen;k++){
         arr[k] = tmpArr[k];
      }
      tmpArr = null;
   }

   public static void up2Down(int[] arr,int start,int end){
      if(null == arr || start >= end){
         return;
      }
      int mid = (start + end)/2;

      up2Down(arr,start,mid);//最后还是拆解成了1
      up2Down(arr,mid+1,end);//最后还是拆解成了1

      merge(arr,start,mid,end);
   }

}
