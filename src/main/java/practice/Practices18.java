package practice;

/**
 * 求一棵树
 * 最大搜索二叉树的个数
 */
public class Practices18 {


}

class Tree18{
    class TNode{
        TNode left;
        TNode right;

        int data;
    }

    class RtnData{
        int max;//左子树最大
        int min;//右子树的最小
        TNode head;
        int size;

        RtnData(int size,TNode head,int max,int min){
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }

    }

    public RtnData process(TNode root){

        if(null == root){
            return new RtnData(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        RtnData leftInfo = process(root.left);
        RtnData rightInfo = process(root.right);

        int leftSize = leftInfo.size;
        int rightSize = rightInfo.size;

        int selfSize = 0;
        //整颗树都是一颗搜索二叉树
        if(leftInfo.head == root.left && rightInfo.head == root.right
        && leftInfo.max < root.data && rightInfo.min > root.data){
            selfSize = leftSize + rightSize + 1;
        }
        int maxSize = Math.max(Math.max(leftSize, rightSize), selfSize);
        TNode maxNode = leftSize > rightSize ? leftInfo.head :
                selfSize > rightSize ? root : rightInfo.head;

        return new RtnData(selfSize, maxNode, leftInfo.max, rightInfo.min);
    }
    /**
     * 求最远距离
     *
     * 高度
     * 距离
     */
}

