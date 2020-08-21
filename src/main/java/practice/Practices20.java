package practice;

/**
 * 求异或和 最大的子数组
 */
public class Practices20 {




    /**
     * 求和为 aim的最长子数组
     */
    public void maxLen(int[] arr,int aim){
        if(null == arr){
            return;
        }
        int R = -1;
        int L = -1;
        int sum = 0;
        int len = 0;
        while(R < arr.length){
            if(sum < aim){
                R++;
                if(R < arr.length){
                    sum = sum + arr[R];
                }else{
                    break;
                }
            }else if(sum == aim){
                len = Math.max(len,R-L);
                L++;
                sum = sum - arr[L];
            }else{
                L++;
                sum = sum - arr[L];
            }
        }

    }

    /**
     * 求小于或等于 aim 的最大数组长度
     * @param arr
     * @param aim
     * @return
     */
    public int lessOrEqual(int[] arr,int aim){
        int[] min_sum = new int[arr.length];
        int[] min_sum_idx = new int[arr.length];

        int arrLen = arr.length;
        min_sum[arrLen -1] = arr[arrLen -1];
        min_sum_idx[arrLen - 1] = arrLen - 1;

        for(int i = arrLen -1;i >= 0;i--){
            if(min_sum[i+1] < 0){
                min_sum_idx[i] = min_sum_idx[i+1];
                min_sum[i] = arr[i] + min_sum[i+1];
            }else{
                min_sum_idx[i] = i;
                min_sum[i] = arr[i];
            }

        }
        int R = 0;
//        int L = 0;
        int maxLen = 0;
        int sum = 0;
        for(int L=0;L < arr.length;L++){
           while(R < arrLen && sum + min_sum[R] <= aim){
               sum = sum + min_sum[R];
               R = min_sum_idx[R] + 1;
           }
           maxLen = Math.max(maxLen,R - L);

           sum = sum - (R == L ? 0 : arr[L]);

           R = Math.max(R,L+1);//R 和L重合
        }

        return  maxLen;
    }
}


