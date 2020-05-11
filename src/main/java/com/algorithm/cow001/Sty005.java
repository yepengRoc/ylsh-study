package com.algorithm.cow001;

/**
 * 暴力递归改为动态规划
 */
public class Sty005 {

    /**
     * 最小路径和
     */

    public int minPathSum(int[][] matrix,int i,int j){
        int x = matrix.length;
        int y = matrix[0].length;
        if(i == x - 1 && j == y - 1){
            return matrix[i][j];
        }
        if(i == x-1){//到达最后一行了
            return matrix[i][j] + minPathSum(matrix,i,j+1);
        }
        if(j == y - 1){//到达最后一列了
            return matrix[i][j] + minPathSum(matrix,i+1,j);
        }

        int left =  minPathSum(matrix,i,j+1);
        int down =  minPathSum(matrix,i+1,j);

        return matrix[i][j] + Math.min(left,down);

    }


    public boolean judge(int[] arr,int index,int rst,int num){
        if(index == arr.length -1){
            if(rst == num){
                return true;
            }
        }

        judge(arr,index+1,rst,num);
        judge(arr,index+1,rst,num+arr[index]);

        return false;
    }
    /**
     * 暴力递归改动态规划。需要再看下
     */
}
