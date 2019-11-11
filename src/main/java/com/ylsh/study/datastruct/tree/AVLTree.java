package com.ylsh.study.datastruct.tree;

/**
 * 高度平衡的二叉树
 * 规则：任何两颗子树的高度差不超过1
 *
 * 插入或删除节点的时候，会导致 子树高度相差2。
 * 主要分这几种情况
 * LL
 * 左左
 * 即根结点的左子树高度 大于根结点的右子树。当删除右子树节点或增加左子树节点时，破坏了高度约束。
 */
public class AVLTree {

    class AvlTreeNode{
        int value;//值
        AvlTreeNode left;//左节点
        AvlTreeNode right;//右节点
        int height;//高度
    }
}
