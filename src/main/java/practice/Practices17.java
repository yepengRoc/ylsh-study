package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 求数组中 和为 aim的 最长子数组长度
 *
 * 求 以数组中每个数为结尾的子数组的长度。
 */
public class Practices17 {

    public static void main(String[] args) {

    }


    public int maxLength(int[] arr,int aim){

        int arrLen = arr.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        int sum = 0;
        int maxlen = 0;
        for(int i=0; i< arrLen; i++){

            sum = arr[i] + sum;
            if(!hashMap.containsKey(sum)){
                hashMap.put(sum,i);
            }

            int gap = sum - aim;
            if(hashMap.containsKey(gap)){
                int index = hashMap.get(gap);
                maxlen = Math.max(maxlen, i - index);
            }
        }
        return maxlen;
    }

    /**
     * 异或问题
     */

}
