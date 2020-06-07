package practice;

public class Practice1 {

    /**
     * 假设 排序的都是正整数
     * 如果有负数。
     * 先把负数 整出来。然后 再排序。
     * 排完序后颠倒
     * @param arr
     * @return
     */
    public int getMaxVal(int[] arr){
        if(null == arr || arr.length < 0){
            return 0;
        }
        int max = 0;
        int arrLen = arr.length;
        for(int i = 0;i < arrLen;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

   public void  baseSort(int[] arr){

        int max = getMaxVal(arr);
        if(max == 0){
            return;
        }
       /**
        * 从 个位数开始。1 10 100
        */
       for(int i = 1;max/i > 0 ;i = i*10){
            sort(arr,i);
        }

    }

    /**
     * 这里可以优化的一点是 可以把 outArr设置为全局变量。这样只申请一次空间
     * @param arr
     * @param base
     */
    public void sort(int[] arr,int base){


        if(null == arr || arr.length < 1){
            return;
        }

        int[] outArr = new int[arr.length];
        int[] tmpArr = new int[10];

        int arrLen = arr.length;
        for(int i = 0;i < arrLen;i++){
            int index = (arr[i] / base) % 10;
            tmpArr[index]++;
        }
        int tmpLen = tmpArr.length;
        for(int i = 1;i< tmpLen; i++){
            tmpArr[i] = tmpArr[i-1] + tmpArr[i];//计算当前数之前有几个数。然后就知道在base中的位置
        }

        for(int i = 0;i < arrLen;i++){
            int index = (arr[i] / base) % 10;
            outArr[tmpArr[index]] = arr[tmpArr[index]];
            tmpArr[index]--;
        }
        int outLen = outArr.length;
        for(int idx = 0;idx < outLen; idx++){
            arr[idx] = outArr[idx];
        }


    }

    public static void main(String[] args) {

    }
}
