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
    }




}
