package com.algorithm.cow001;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 */
public class Sty001 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(10);
    }
}



class Tree{
    class Node{
        Node left;

        Node right;

        Node parent;//父节点

        int data;
    }

    Node root;

    public void addNode(int val){
        Node addNode = new Node();
        addNode.data = val;
        if(root == null){
            root = addNode;
            return;
        }
        Node tmpRoot = root;
        while(tmpRoot != null){
            if(tmpRoot.data > val){
                if(null == tmpRoot.left){
                    tmpRoot.left = addNode;
                    break;
                }
                tmpRoot = tmpRoot.left;
            }else if(tmpRoot.data < val){
                if(tmpRoot.right == null){
                    tmpRoot.right = addNode;
                    break;
                }
                tmpRoot = tmpRoot.right;
            }
        }


    }

    //先序  根节点
    public void preRecusive(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preRecusive(root.left);
        preRecusive(root.right);
    }
    //中序
    public void midRecusive(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.left);
        System.out.println(root.data);
//        midRecusive(root);
        midRecusive(root.right);

    }
    //后序
    public void afterRecusive(){
        if(root == null){
            return;
        }
        System.out.println(root.left);
        midRecusive(root.right);
        System.out.println(root.data);
//        midRecusive(root);
    }


    public void preOrder(Node root){
        Stack<Node> stack = new Stack<>();//先进后出
        /**
         * 前序的时候是 先根  在左 再右
         * 根据栈的特点 需要先压右 再压左 ，然后依次弹出
         */
        stack.push(root);

        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.data);

            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }

    }

    public void midOrder(Node root){
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() && root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }

    }

    public void afgerOrder(Node root){
        /**
         * 后序的遍历顺序是  左 右 中  所以存入的顺序应该是 中 右  左
         *
         * 因为有两个栈，所以真正的
         */
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while(root != null){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null){//先进
                stack1.push(root.left);
            }
            /**
             * 根据栈的特点先进后出.所以right要后进先出，在stack1中会先被弹出，进入stack2 然后由根据先进后出，所以最终
             * 在stack2中的顺序是 左  右  中
             */
            if(root.right != null){//
                //
               stack1.push(root.right) ;
            }
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }
    }

    /**
     * 后续遍历的第二种方式 --需要再研究下
     */


    /**
     * 后继节点  --
     * 中序遍历的后面一个节点  叫后继
     *  特点 大于当前节点的最小节点
     * 中序遍历的前面一个节点 叫前驱
     *  小于当前节点的最大节点
     */
    public Node afterHouJi(Node node){

        if(node.right != null){
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else{//没有右
            Node parent = node.parent;
            while(parent != null && node != parent.left){
                node = parent;
                parent = parent.parent;
            }
            return  parent == null ? null:parent;
        }
    }

    public Node preQianQu(Node node){
        Node rst = null;
        if(null != node.left){
            node = node.left;
            while(node.right != null){
                node = node.right;
            }
            return node;
        }else{
            Node parent = node.parent;
            while (parent != null && node != parent.right){
                node = parent;
                parent = parent.parent;
            }
            return parent == null ? null : parent;
        }
    }

    /**
     * 序列化一颗树，每个节点都需要分开 用！分开 然后空节点需要标识出来 这里用#
     */

    public String seriaTree(Node root){
        if(null == root){
            return "!#";
        }
        String str = root.data + "!";
        str += seriaTree(root.left);
        str += seriaTree(root.right);
        return str;
    }

    public void reconStruct(String str){
        String[] strArr = str.split("!");

        Queue<String> queue = new LinkedList<>();
        for(String s : strArr){
            queue.offer(s);
        }
        recon(queue);
    }

    public Node recon(Queue<String> queue){


        String str = queue.poll();
        if("#".equals(str)){
            return null;
        }
        Node node = new Node();
        node.data = Integer.parseInt(str);
        node.left = recon(queue);
        node.right = recon(queue);
        return  node;

    }

    /**
     * 判断一棵树是否是平衡二叉树
     * 平衡二叉树的定义 左右子树的高度不超过1
     *
     *
     */
    class  ReturnData{
        boolean isBalance;
        int height;
        ReturnData(boolean isBalance,int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public ReturnData isBalenceTree(Node root){

        if(root == null){
            return new ReturnData(true,0);
        }
        ReturnData left = isBalenceTree(root.left);
        if(!left.isBalance){
            return new ReturnData(false,0);
        }
        ReturnData right = isBalenceTree(root.right);
        if(!right.isBalance){
            return new ReturnData(false,0);
        }
        if(Math.abs(left.height - right.height) > 1){
            return new ReturnData(false,0);
        }
        return new ReturnData(true,Math.max(left.height,right.height) + 1);
    }


    /**
     * 判断是否是搜索二叉树
     * 特点是 左子树的节点肯定都小于根 右子树肯定都大于根
     * 对树进行非递归中序遍历如果
     * 其中有一个后继节点的值 小于前一个，则不是搜索树
     */


    /**
     * 判断一个二叉树是否是完全二叉树
     *  完全二叉树的定义，如果有孩子节点在，则必须先有左孩子，否则不是完全二叉树
     *  按层进行遍历
     *  用queque 存储  LinkedList
     *
     */

    /**
     * 求一个满二叉树中节点的个数
     *
     * 没看懂，需要再看看-- 看 左神的书中讲解
     */
}
