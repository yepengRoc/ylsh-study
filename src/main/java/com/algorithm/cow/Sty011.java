package com.algorithm.cow;

/**
 * 给定一个有序矩阵从 从左到右 。从右往下有序
 *
 * 查找一个数是否在矩阵中
 */
public class Sty011 {

    public static void main(String[] args) {
        int[] rightUp = {0,4};
        int rows = 3;
        int cols = 4;
        int num = 5;
        int[][] matrix = new int[4][5];

        while(rightUp[0] <= rows && rightUp[1] >= 0){
            if(matrix[rightUp[0]][rightUp[1]] < num){
                rightUp[0]++;
            }else if(matrix[rightUp[0]][rightUp[1]] > num){
                rightUp[1]--;
            }else{
                //找到了
            }
        }
        //执行到这一步标识没有找到
    }
}
