package com.algorithm.sort;

public class RadixSort {


  /*
   * 获取数组a中最大值
   *
   * 参数说明：
   *     a -- 数组
   *     n -- 数组长度
   */
         private static int getMax(int[] a) {
             int max;

             max = a[0];
             for (int i = 1; i < a.length; i++)
                     if (a[i] > max)
                         max = a[i];

             return max;
         }

    /*
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明：
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    private static void countSort(int[] a, int exp) {
         //int output[a.length];    // 存储"被排序数据"的临时数组
         int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
         int[] buckets = new int[10];
             // 将数据出现的次数存储在buckets[]中
         for (int i = 0; i < a.length; i++)
                 buckets[ (a[i]/exp)%10 ]++;
             // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        /**
         * 主要是计算 排序的数 前面有几个数
         */
         for (int i = 1; i < 10; i++)
                 buckets[i] += buckets[i - 1];
             // 将数据存储到临时数组output[]中
        /**
         * 为什么从最后一个往前遍历，因为一次排序后，会有一个定的顺序，
         * 后面再次排序的时候，可以保证这种顺序不变
         * 例如 3 63   按照1排序的时候 可能 63 3 在3前面
         * 但是按照 10 排序的时候3 63 肯定跑到了后面
         * 按照100排序的时候 3 63 都是除 100都是0 ，那这个时候就有讲究了，3 63的位置不能变，保证大的数在小的数后面，
         * 所以从后面遍历，刚好就实现了这种效果，相同余数 先计算的会占据高位，一次递减
         */
         for (int i = a.length - 1; i >= 0; i--) {//

                 output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
                 buckets[ (a[i]/exp)%10 ]--;
             }
             // 将排序好的数据赋值给a[]
         for (int i = 0; i < a.length; i++)
                 a[i] = output[i];
             output = null;
         buckets = null;
     }

             /*
     * 基数排序
     *
     * 参数说明：
     *     a -- 数组
     */
        public static void radixSort(int[] a) {
            int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
            int max = getMax(a);    // 数组a中的最大值

            // 从个位开始，对数组a按"指数"进行排序
            for (exp = 1; max/exp > 0; exp *= 10)
                    countSort(a, exp);
        }

  public static void main(String[] args) {
      int i;
      int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};

      System.out.printf("before sort:");
      for (i=0; i<a.length; i++)
              System.out.printf("%d ", a[i]);
      System.out.printf("\n");

      radixSort(a);    // 基数排序

      System.out.printf("after  sort:");
      for (i=0; i<a.length; i++)
              System.out.printf("%d ", a[i]);
      System.out.printf("\n");
  }
}
