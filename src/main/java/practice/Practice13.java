package practice;

/**
 * 暴力递归改动态规划
 */
public class Practice13 {


    /**
     * 二维数组 从某一点出发只能 往右 或往下，求最小路径和
     */

    public static int minPathSum(int[][] matrix,int row,int col){
        if(row == matrix.length - 1 && col == matrix[0].length - 1){
            return matrix[row][col];
        }
        if(row == matrix.length - 1){
            return matrix[row][col] + minPathSum(matrix,row,col+1);
        }
        if(col == matrix[0].length - 1){
            return matrix[row][col] + minPathSum(matrix,row+1,col);
        }

        int right = matrix[row][col] + minPathSum(matrix,row,col+1);//向右
        int down = matrix[row][col] + minPathSum(matrix,row+1,col);//向下
        return matrix[row][col] + Math.min(right,down);
    }


}
