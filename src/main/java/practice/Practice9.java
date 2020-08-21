package practice;

import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 */
public class Practice9 {

    class Tree{

        class Node{
            Node left;

            Node right;

            Node parent;

            int val;
        }

        Node root;

        public void preOrder(){

            Stack<Node> stack = new Stack<>();

            stack.push(root);

            while(!stack.empty()){
                Node node = stack.pop();
                System.out.println(node.val);
                if(null != node.right){
                    stack.push(node.right);
                }
                if(null != node.left){
                    stack.push(node.left);
                }

            }

        }

        /**
         * 中序遍历
         */
        public void medOrder(){
            Stack<Tree.Node> stack = new Stack<>();

            while(!stack.isEmpty() || root != null){

                if(root != null){
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }

        /**
         * 后序遍历
         */
        public void afterOrder(){

            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();

            stack1.push(root);
            while(!stack1.empty()){
                Node node = stack1.pop();

                if(node.left != null){
                    stack1.push(node.left);
                }
                if(node.right != null){
                    stack1.push(node.right);
                }
                stack2.push(node);

            }
            while(!stack2.empty()){
                Node node = stack2.pop();
                System.out.println(node.val);
            }
        }

        public void afterOrder2(){

            Stack<Node> stack = new Stack<>();
            stack.push(root);
            Node h = null;
            Node c = null;
            while(!stack.isEmpty()){
                c = stack.peek();

                if(c.left != null && c.left != h && c.right != h){
                    stack.push(c.left);
                }else if(c.right != null && c.right != h){
                    stack.push(c.right);
                }else{
                    System.out.println(stack.pop().val);
                    h = c;
                }
            }
        }

        /**
         * 查找后继节点
         */
        public Node findHouji(Node node){
            if(node == null){
                return null;
            }
            Node right = node.right;
            Node suc = null;
            if(right != null){
                while (right.left != null){
                    right = right.left;
                }
                return right;
            }else{
                Node parent = node.parent;

                while(parent != null && parent.left != node){
                    node = parent;
                    parent = parent.parent;
                }
                return parent == null ? null : parent;
            }

        }

        /**
         * 查找前驱节点
         * @param node
         * @return
         */
        public Node findQianQu(Node node){
            if(node == null){
                return null;
            }
            Node suc = node.left;

            if(suc != null){
                while (suc.right != null){
                    suc = suc.right;
                }
                return suc;
            }else{
                Node parent = node.parent;

                while(parent != null && parent.right != node){
                    node = parent;
                    parent = parent.parent;
                }
                return parent == null ? null : parent;
            }

        }

        /**
         * 二叉树的序列化
         */
        public String seria(Node node){
            if(null == node){
                return "#";
            }
            String str = node.val + "!";
            str = str + seria(node.left);
            str = str + seria(node.right);
            return str;
        }

        public void reconstrust(String str){
            String[] strArr = str.split("!");

            Queue<String> queue = new LinkedList<>();

            for(String str1 : strArr){
                queue.offer(str1);
            }

        }

        public Node recon(Queue<String> queue){

            String str = queue.poll();
            if(str == "#"){
                return null;
            }
            Node node = new Node();
            node.val = Integer.parseInt(str);
            node.left = recon(queue);
            node.right = recon(queue);
            return  node;
        }

        /**
         * 判断一颗树是否是平衡二叉树
         */
        class Balance{
            int height;
            boolean isBalance;
            Balance(int height,boolean isBalance){

            }
        }

        public int isBalanceTree(Node node){
            if(node == null){
                return  0;
            }
            int left = isBalanceTree(node.left);
            if(left < 0){
                return left;
            }
            int right = isBalanceTree(node.right);
            if(right < 0){
                return right;
            }
          int dif = Math.abs(left - right);
          if(dif > 1){
              return -1;
          }

            return Math.max(left,right) + 1;
        }

        public Balance isBalance(Node node){
            if(node == null){
                return new Balance(0,true);
            }
            Balance leftData = isBalance(node.left);
            if(!leftData.isBalance){
                return new Balance(0,false);
            }
            Balance right = isBalance(node.right);
            if(!right.isBalance){
                return new Balance(0,false);
            }
            int dif = Math.abs(right.height - leftData.height);
            if(dif > 1){
                return new Balance(0,false);
            }
            return new Balance(dif + 1,false);

        }


        /**
         * 判断是否是一个搜索二叉树
         * 左子树 小于 根  右子树 大于根
         *
         * 第二种情况：中序遍历，看是否。是一个递增结果集
         */

        public boolean isSearchTree(Node node){

            if(null != node){
                if(null != node.left && node.left.val > node.val){
                    return false;
                }

                if(null != node.right && node.right.val < node.val){
                    return false;
                }
                    return isSearchTree(node.right) && isSearchTree(node.left);

            }
            return true;
        }

        /**
         * 判断是否是完全二叉树
         *
         * 只有右孩子 没有左孩子 不是
         * 有左孩子，没有右孩子，则左孩子右边的节点都是叶子节点
         *
         *    a   c  d  e
         *    /
         *    b
         *    if(node.left == null && node.right != null){
         *        return false;
         *    }
         *
         */

        public boolean isCompleteTree(){

            Queue<Node> queue = new LinkedList<>();

            boolean leaf = false;
            queue.offer(root);

            while(!queue.isEmpty()){

                Node node = queue.poll();

                if(null == node.left && null != node.right){
                    return false;
                }

                if(leaf && (null != node.left || null != node.right)){
                    return false;
                }
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }else{//说明只能是叶子节点
                    leaf = true;
                }

            }
            return false;
        }

        /**
         * 求一颗完全二叉树节点的个数
         *
         * 左右相差高度为1
         * 如果有左 右孩子可有 可无
         *
         * 可以回锅  -- 暂时没看太明白 TODO
         *
         * 左子树的最后一个节点可能在 最后一层的任何一个位置
         */



    }




}
