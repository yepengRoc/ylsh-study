package com.algorithm.base;

/**
 * AVL树
 * 两个子树的高度相差不能超过1
 *
 * 旋转，在插入或删除节点的时候，会导致树高度的变化，如果高度相差大于1，要做旋转处理
 * 左旋
 * 右旋
 *
 */
public class AVLTree {



    class Node{

        int value;

        Node left;

        Node right;

        Node parent;

        int height;//空的树高度为0

        Node(int value,Node left,Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    Node root;


    /**
     * 左旋  以给定节点node为根节点，旋转左侧的子树到右侧
     *
     * 需要补图
     *
     *
     */
    public void leftRotation(Node node){
        if(node == null){
            return;
        }
        Node left = node.left;
       // Node riht = node.right;

        node.left = left.right;
        left.right = node;
        //修改parent指向
        left.parent = node.parent;
        if(left.parent == null){
            root = left;
        }else{
            if(node.parent.left == node){
                left.parent.left = left;
            }else if(node.parent.right == node){
                left.parent.right = left;
            }
        }
       // if(null != left.right){
            left.right.parent = left;
        //}
        if(null != node.left){
            node.left.parent = node;
        }
    }

    /**
     * 右旋  以当前给定节点node为根节点，旋转右子树到左侧
     * @param node
     */
    public void rightRotation(Node node){
        if(null == node){
            return;
        }
        Node right = node.right;

        node.right = right.left;
        if(node.right != null){
            node.right.parent = node;
        }
        right.left = node;
        right.left.parent = right;

        right.parent = node.parent;
        if(right.parent == null){//说明是跟节点
            root = right;
        }else{
            if(node.parent.left == node){
                node.parent.left = right;
            }else if(node.parent.right == node){
                node.parent.right = right;
            }
        }
    }

    /**
     * 求传入节点的层高
     * @param node
     * @return
     */
    public int height(Node node){
        return 0;
    }
}
