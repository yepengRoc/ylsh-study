package com.algorithm.cow;

/**
 * 顺时针旋转 正方形矩阵
 */
public class Sty009 {

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

        //找出4个点
        int[] p1 = {leftUp[0],leftUp[1]};
        int[] p2 = {leftUp[0],rightDown[1]};
        int[] p3 = {rightDown[0],rightDown[1]};
        int[] p4 = {rightDown[0],leftUp[1]};

        while(p1[1] < rightDown[1]){
            int tem = matrix[p1[0]][p1[1]];

            matrix[p1[0]][p1[1]] = matrix[p4[0]][p4[1]];
            matrix[p4[0]][p4[1]] = matrix[p3[0]][p3[1]];
            matrix[p3[0]][p3[1]] = matrix[p2[0]][p2[1]];
            matrix[p2[0]][p2[1]] = tem;

            p1[1]++;//列增加
            p2[0]++;//行增加
            p3[1]--;//列减少
            p4[0]--;//行减少

        }


    }
}
