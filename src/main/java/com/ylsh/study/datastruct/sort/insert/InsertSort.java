package com.ylsh.study.datastruct.sort.insert;

/**
 * 插入排序
 * 
 * @author YePengPeng--2017年11月13日
 * 
 *         一个有序 一个无序
 *
 */
public class InsertSort {

    public static void sort(int[] arr) {
        int arrLen = arr.length;

        int i, j, k;

        for (i = 1; i < arrLen; i++) {
            for (j = i - 1; j >= 0; j--) {// 从 0 到 i-1的位置 给i找位置。从右起 找第一个比i小的元素 然后 把当前位置到 i-1都后移
                if (arr[j] < arr[i]) {
                    break;
                }
            }

            // 如找到了一个合适的位置
            if (j != i - 1) {
                // 将比a[i]大的数据向后移
                int temp = arr[i];
                for (k = i - 1; k > j; k--)
                    arr[k + 1] = arr[k];
                // 将a[i]放到正确位置上
                arr[k + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 25, 60, 50};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
