package com.ylsh.study.datastruct.sort.quick;

/**
 * 快速排序
 * 
 * @author YePengPeng
 * 
 *         快速排序 采用分而治之的思想。找到一个基准数，比基准数小的放一边，比基准书大的放另外一边
 *
 */
public class QuickSort {

    public static void sort(int[] arr, int left, int right) {

        int lef = left;
        int righ = right;
        int base = arr[lef];

        while (arr[righ] > base && lef < righ) {// 从右向左找小于base的
            righ--;
        }

        if (lef < righ) {
            // arr[lef++] = arr[righ];
            arr[lef] = arr[righ];
            lef++;
            // 等价于 arr[lef] = arr[righ]; lef++
        }

        while (arr[lef] < base && lef < righ) {// 从左向右找第一个大于base的
            lef++;
        }
        if (lef < righ) {
            arr[righ] = arr[lef];
            righ--;
            // arr[righ--] = arr[lef];
        }

        arr[lef] = base;

        sort(arr, left, lef - 1);
        sort(arr, lef + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int i = 2;
        System.out.println(arr[++i]);
    }

}
