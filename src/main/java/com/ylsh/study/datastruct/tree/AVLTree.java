package com.ylsh.study.datastruct.tree;

/**
 * 高度平衡的二叉树
 * 规则：任何两颗子树的高度差不超过1
 */
public class AVLTree {

    class AvlTreeNode{
        int value;//值
        AvlTreeNode left;//左节点
        AvlTreeNode right;//右节点
        int height;//高度
    }
}
