package practice;

public class Practice2 {

    public void insert(int[] arr){
        int len = arr.length;

        for(int i=1;i < len; i++){
            for(int j=i;j>0;j--){
                if(arr[j] < arr[j-1]){
                    /**
                     * 交换元素
                     */

                }

            }
        }
    }

    /**
     * 荷兰国旗问题
     * @param arr
     * @param num
     */
    public void hlgq(int[] arr,int num){

        int left = -1;
        int right = arr.length;

        int start = left+1;
        while (start < right-1){
            if(arr[start] < num){
                //交换  left++ arr[left]和 arr[start]交换
                left++;
                if(left != start){
                    swap(arr[left],arr[start]);
                }
                start++;
            }if(arr[start] > num){
                right--;
                swap(arr[right],arr[start]);
            }else{//相等
                start++;
            }
        }

    }

    public void swap(int a,int b){

    }

    /**
     * 转圈打印矩阵
     * 找共性
     */
    public void print(int[][] arr){
        int arrLen = arr.length;
        int[] leftUp = {0,0};

        int[] rightDown = {arr[arrLen-1][arrLen-1],arr[arrLen-1][arrLen-1]};

        while (leftUp[0] < rightDown[0]){
            acturePrint(arr,leftUp,rightDown);

            leftUp[0] = leftUp[0]+1;
            leftUp[1] = leftUp[1] + 1;

            rightDown[0] = rightDown[0] -1;
            rightDown[1] = rightDown[1] - 1;
        }
    }
    public void acturePrint(int[][] arr,int[] leftUp,int[] rightDown){
        int leftUpRow = leftUp[0];
        int leftUpCol = leftUp[1];

        int rightDownRow = rightDown[0];
        int rightDownCol = rightDown[1];

        while(leftUpCol < rightDownCol){
            System.out.println(arr[leftUpRow][leftUpCol]);
            leftUpCol++;
        }
        while(leftUpRow < rightDownRow){
            System.out.println(arr[leftUpRow][leftUpCol]);
            leftUpRow++;
        }
        while(rightDownCol > leftUp[1]){
            System.out.println(arr[rightDownRow][rightDownCol]);
            rightDownCol--;
        }
        while(rightDownRow > leftUp[0]){
            System.out.println(arr[rightDownRow][rightDownCol]);
            rightDownRow--;
        }
    }


    /**
     * 旋转方块矩阵
     */
    public void print1(int[][] arr,int[] leftUp,int[] rightDown){
        int[] p1 = {leftUp[0],leftUp[1]};
        int[] p2 = {leftUp[0],rightDown[1]};
        int[] p3 = {rightDown[0],rightDown[1]};
        int[] p4 = {rightDown[0],leftUp[1]};

        while(p1[1] < rightDown[1]){
            int tmp = arr[p4[0]][p4[1]];

            arr[p4[0]][p4[1]] = arr[p3[0]][p3[1]];
            arr[p3[0]][p3[1]] = arr[p2[0]][p2[1]];
            arr[p2[0]][p2[1]] = arr[p1[0]][p1[1]];
            arr[p1[0]][p1[1]] = tmp;

            p1[1]++;
            p2[0]++;
            p3[1]--;
            p4[0]--;
        }
    }

    /**
     * 之字形 打印矩形
     */
    public void print3(int[][] arr){
        int col = arr[0].length;
        int row = arr.length;
        int[] leftD = {0,0};
        int[] rigtU = {0,0};

        boolean turnUp = true;//向上

        while(leftD[1] < col){

            if(leftD[0] < row){
                leftD[0]++;
            }else{
                leftD[1]++;
            }
            if(rigtU[1] < col){
                rigtU[1]++;
            }else{
                rigtU[0]--;
            }
        }
    }

    public void acturePrint3(int[][] arr,int[] leftD,int[] rightU,boolean turnUp){
        int i = leftD[0];
        int j = rightU[1];
        if(turnUp){
            while( j < rightU[1]){// i >=
                System.out.println(arr[i][j]);
                i--;
                j++;
            }
        }else{
           while( i < leftD[0]){
               System.out.println(arr[i][j]);
               i++;
               j--;
           }
        }
    }

    /**
     * 在一个 从左到右 从上到下 依次 底层的矩阵里
     * 查找某一个数
     */
    public boolean find(int[][] arr,int num){
        int row = 0;
        int col = arr[0].length -1;
        while(row < arr.length && col > -1){
            if(arr[row][col] > num){
                col--;
            }else if(arr[row][col] < num){
                row++;
            }else{
                return true;//找到了
            }
        }
        return false;
    }

    /**
     * 二维数组中 为上下左右 连载一起的 为1的数，称为岛
     *
     * 求一个二维数组中有多少个岛
     */

    public void dao(int[][] arr){
        int row = 0;
        int col = 0;
        int rst = 0;
        for(int i=0;i< row;i++){
            for(int j=0;j< col;j++){
                if(arr[i][j] == 1){
                    rst++;
                    infect(arr,i,j);
                }
            }
        }
    }

    /**
     *
     */
    public void infect(int[][] arr,int row,int col){

        if(row > arr.length -1 || col > arr[0].length-1 || arr[row][col] != 1){
            return;
        }

        if(arr[row][col] == 1){
            arr[row][col]= 2;
        }
        infect(arr,row,col-1);
        infect(arr,row,col+1);
        infect(arr,row-1,col);
        infect(arr,row+1,col);
    }



}
