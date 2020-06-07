package com.algorithm.plastic;

public class ShellSort {
    //跟直接排序相似。不过要选定步长
    public static void sort(int[] arr){
        int len = arr.length;

        for(int step = len/2;step > 0;step = step/2){
            for(int i = 0; i< step;i++){
                for(int j = i+ step;j< len; j = j+step){
                    if(arr[j] < arr[j-step]){
                        int value = arr[j];
                        int k = j - step;
                        while(k >= 0&&arr[k]> value){//往前找。找到 value应该在的位置
                            arr[k+step] = arr[step];
                            k = k - step;
                        }
                        arr[k+step] = value;
                    }
                }
            }
        }

    }

    public void practic(){
        int[] arr = new int[]{};

        int len = arr.length;

        for(int step = len/2;step > 0;step = step/2){
            for(int i = 0;i < step; i++){
                for(int j=i+step; j < len;j = j+step){
                    //进行 j 和 j-step的比较。
                    if(arr[j] < arr[j-step]){
                        int val = arr[j];
                        int k = j-step;
                        /**
                         * 继续往前找。找到一个适合 arr[j]的位置
                         */
                        while(k > 0 && arr[k] > val){
                            arr[k+step] = arr[k];
                            k = k - step;
                        }
                        arr[k+step] = val;
                    }
                }
            }
        }
    }
}
