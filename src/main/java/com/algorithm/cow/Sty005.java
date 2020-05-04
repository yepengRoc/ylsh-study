package com.algorithm.cow;

/**
 * 快排前序
 *
 *
 */
public class Sty005 {

    /**
     * 给定一个数，和一个数组，把小于这个数的数 放数组左边，大于这个数的数，
     * 放数组右边
     *  1 2 3 4 5
     *  设定一个指针pos 指向 -1位置，遍历数组
     *  当数组中下标为i的元素小于num时，则将此小于的值和pos的下一个位置进行置换，
     *  如果 i位置的值大于等于 num,则不进行任何操作
     *
     */
    public static void method1(int[] arr,int num){

        int pos = -1;//不用进行0判断

        int len = arr.length;

        for(int i=0;i < len; i++){
            if(arr[i] < num){//符合题意 。进行交换。和pos的下一个位置进行交换
                pos++;
                if(i != pos){
                    swap(arr,pos,i);
                }
            }
        }
    }


    public static  void swap(int[] arr,int a,int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[a];
        arr[a] = arr[a] ^ arr[b];
    }

    /**
     * 给定一个数组arr  和一个数 num
     * 小于 num的数，放数组 arr左边，等于num的数放数组中间 ，大于num的数 放数组右边
     */
    public static void method2(int[] arr,int num){
        int left = -1;
        int right = arr.length;

        int len = arr.length;

        for(int i =0 ;i < len;){
            if(arr[i] < num){//进行替换
                left++;
                if(left != i){
                    swap(arr,left,i);
                }
            }else if(arr[i] > num){//找到大于num的数，放到末尾指针减1的位置。因为i位置被置换了。所以，不要i++。从新对i位置进行判断
                right--;
                if(right != i){
                    swap(arr,i,right);
                }
                continue;
            }
            i++;
        }

    }




}
