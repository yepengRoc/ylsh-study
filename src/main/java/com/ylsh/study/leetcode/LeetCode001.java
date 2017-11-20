package com.ylsh.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author YePengPeng--2017年11月10日
 * 
 *         Given an array of integers, find two numbers such that they add up to a specific target
 *         number.
 * 
 *         The function twoSum should return indices of the two numbers such that they add up to the
 *         target, where index1 must be less than index2. Please note that your returned answers
 *         (both index1 and index2) are not zero-based. 答案不能从索引 0 开始 。即表示 从真实位置开始。索引0的真实位置是1
 * 
 *         You may assume that each input would have exactly one solution.
 * 
 *         Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 *
 */
public class LeetCode001 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // key = target - nums[i], just one solution 如果有重复数字。只会记录一个
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer v = map.get(nums[i]);
            // can't use itself 元素不能使用自身
            if (v != null && v != i) {
                return new int[] {i + 1, v + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 15};
        arr = twoSum(arr, 9);
        if (arr != null) {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
        }
    }
}
