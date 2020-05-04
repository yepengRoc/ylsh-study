package com.algorithm.cow;

/**
 * 之字形  打印矩阵
 */

public class Sty010 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};//      new  int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};//

        printMatrixCircle(matrix);

    }


    public static void printMatrixCircle(int[][] matrix ){
        boolean printReverse = true;//true 控制从左下角 向右上角打印  false 右上角 向左下角打印  upToDown   从下往上，从上往下

        int cols = matrix[0].length;//一共有多少列
        int rows = matrix.length;

        int[] leftDown = {0,0};//左下角
        int[] rightUp = {0,0};//右上角

        while(leftDown[1] <= cols){
            printSquare(matrix,leftDown,rightUp,printReverse);
            printReverse = !printReverse;

            if(leftDown[1] < rows){
                leftDown[0]++;
            }else{
                leftDown[1]++;
            }

            if(rightUp[1] < cols){
                rightUp[1]++;
            }else{
                rightUp[0]++;
            }

        }


    }

    public static void printSquare(int[][] matrix,int[] leftDown,int[] rightUp,boolean printReverse){

        int row;
        int col;
        if(printReverse){
            row = leftDown[0];
            col = leftDown[1];
            while (col <= rightUp[1]){
                System.out.println(matrix[row][col]);
                row--;
                col++;
            }

        }else {
            row = rightUp[0];
            col = rightUp[1];
            while (row <= leftDown[0]){
                System.out.println(matrix[row][col]);
                row++;
                col--;
            }
        }








    }
}
