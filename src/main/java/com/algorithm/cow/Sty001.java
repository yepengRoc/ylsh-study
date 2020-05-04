package com.algorithm.cow;

public class Sty001 {
    /**
     * 有序数据 A  无序数组B 打印 B中在A中的数
     * @param args
     */
    public static void main(String[] args) {
            int[] a = new int[]{1,2,5,6,8,9,23,30};

             int[] b = new int[]{0,2,5,7,8,11,23};
        method3(a,b);
    }

    /**
     * for b
     *  for a
     * 两层循环，如果在b中就进行打印
     */
    public static void method1(){

    }

    /**
     * 因为A有序，可以利用二分查找，查找b中的元素是否在a中
     * @param aArr
     * @param bArr
     */
    public static void method2(int[] aArr,int[] bArr){

        if(bArr == null){
            return ;
        }
        int blen = bArr.length;
        for(int i =0;i < blen;i++){
            binarySearch(aArr,bArr[i]);
        }

    }

    public static void binarySearch(int[] aArr,int val){
        if(aArr == null){
            return;
        }
        int aLen = aArr.length;
        int left = 0;
        int rignt = aArr.length;
        while (left <= rignt){
            int midPosition = (left + rignt) >> 2;
            int midVal = aArr[midPosition]  >> 2;
            if(midVal > val){
                rignt = midPosition - 1;
            }else if(midVal < val){
                left = midPosition + 1;
            }else{
                System.out.println(midVal);
            }
        }
    }

    /**
     * 先对 b进行排序，假设b现在已经有序
     *
     *
     */
    public static void method3(int[] aArr,int[] bArr){
        if(null == aArr || null == bArr){
            return ;
        }
        int aLen = aArr.length;
        int bLen = bArr.length;
        int ai = 0;
        int bi = 0;
        while(ai < aLen && bi < bLen){
            if(aArr[ai] < bArr[bi]){
                ai++;
            }else if(aArr[ai] > bArr[bi]){
                bi++;
            }else{
                System.out.println(aArr[ai]);
                ai++;
                bi++;
            }
        }
    }
}
