package com.algorithm.cow;

/**
 * 转圈打印矩阵，二维数组的第一个节点， 左上角
 * 需要抠清边界
 */
public class Sty008 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};//      new  int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};//

        printMatrixCircle(matrix);

    }

    public static void printMatrixCircle(int[][] matrix ){
        int len = matrix.length;
        int[] leftUp = {0,0};//matrix[]{0,0};  记录左上角位置。第一个数代表行 第二个数代表列
        int[] rightDown = {len - 1,len -1};//matrix[len - 1];

        //左上角数组
        while(leftUp[0] < rightDown[0] && leftUp[1] < rightDown[1]){
            printSquare(matrix,leftUp,rightDown);
            leftUp[0]++;
            leftUp[1]++;
            rightDown[0]--;
            rightDown[1]--;
        }


    }

    public static void printSquare(int[][] matrix,int[] leftUp,int[] rightDown){

        int row = leftUp[0];
        int col = leftUp[1];
        while(col < rightDown[1]){
            System.out.println(matrix[row][col]);
            col++;
        }
        while (row < rightDown[0]){
            System.out.println(matrix[row][col]);
            row++;
        }
        while (col > leftUp[1]){
            System.out.println(matrix[row][col]);
            col--;
        }
        while(row > leftUp[0]){
            System.out.println(matrix[row][col]);
            row--;
        }

    }


}
