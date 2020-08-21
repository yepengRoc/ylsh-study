package practice;

public class Practice5 {

    /**
     * 排序算法 冒泡  则 大的向上调整
     *
     * 选择 。每次选择最小的一个数，放入 头部
     *
     * 插入，在已排好序的前面，插入当前要排的数字 从1开始
     * 思想是：前面已经排好序，选择合适的位置插入即可
     *
     *
     *
     */

    /**
     * 归并排序
     *
     */

    public void merge(int[] arr,int[] help,int start,int end){

        //空判断
        int mid = (start + end) >> 1;
        merge(arr,help,start,mid);
        merge(arr,help,mid+1,end);
        actureMerge(arr,help,start,mid,end);

    }

    public void actureMerge(int[] arr,int[] help,int start,int mid,int end){

        int left = start;
        int right = mid+1;
        int i = start;
        while(left <= mid && right <= end){
            if(arr[left] < arr[right]){
                help[i] = arr[left];
                i++;
                left++;
            }else{
                help[i] = arr[right];
                i++;
                right++;
            }
        }

            while(left != mid + 1){
                help[i] = arr[left];
                i++;
                left++;
            }
            while(right != end + 1){
                help[i] = arr[right];
                i++;
                right++;
        }

    }


    /**
     * 小和问题
     * merge(arr,help,start,mid);
     *         merge(arr,help,mid+1,end);
     *         actureMerge(arr,help,start,mid,end);
     *
     *         int sum = 0;
     *          if(arr[left] < arr[right]){
     *          sum = ((end - right) + 1) * arr[left]
     *                 help[i] = arr[left];
     *                 i++;
     *                 left++;
     *             }else{
     *                 help[i] = arr[right];
     *                 i++;
     *                 right++;
     *             }
     *
     *
     */

    /**
     * 逆序对问题
     *
     *  int sum = 0;
     *   if(arr[left] > arr[right]){
     *          为一个逆序对  记录下 left  right
     *          help[i] = arr[right];
     *          i++;
     *          right++;
     *      }else{
     *          help[i] = arr[left];
     *          i++;
     *          left++;
     *      }
     */


    /**
     * 快排。
     * 找到一个参考数的。 比这个数小的数 放左边。大的数放右边
     */
    public int partition(int[] arr,int start,int end){
        int small = start -1;
        for(int i=0;i < end; i++){
            if(arr[i] < arr[end]){
                small++;
                if(small + 1 != i){//相邻则 不用交换，不相邻才交换
                    //交换
//                    swap(arr,small,i);
                }
            }
        }
        small++;
      //  swap(arr,small,end);
        return small;
    }
    public void quickSort(int[] arr,int start,int end){

        int mid = partition(arr,start,end);
        quickSort(arr,start,mid);
        quickSort(arr,mid+1,end);
    }
    /**
     * 荷兰国旗改进
     * 随机快排改进
     *
     * 很不错的思想
     */
}
