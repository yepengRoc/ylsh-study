package com.ylsh.study.datastruct.tree;
/**
 * 二叉树的简单实现
 * @author Administrator
 *
 */
public class BinaryTree {

	public class Node{
		public int value;//值
		
		public Node parent;//父节点
		
		public Node left;//左孩子的值
		
		public Node right;//右孩子的值
		
		public Node(int value,Node parent,Node left,Node right){
			this.value = value;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
	}
	
	public Node root;//跟节点
	/**
	 * 前序遍历
	 * 前序遍历 根节点
	 * 前序遍历 左子树
	 * 前序遍历右子树
	 */
	public void preTraverse(Node binaryNode){
		System.out.println(binaryNode.value);
		preTraverse(binaryNode.left);
		preTraverse(binaryNode.right);
		
	}
	/**
	 * 中序遍历
	 * 左子树
	 * 根节点
	 * 右子树
	 * 
	 * @param binaryTree
	 */
	public void midTraverse(Node binaryNode){
		preTraverse(binaryNode.left);
		System.out.println(binaryNode.value);
		preTraverse(binaryNode.right);
	}

	/**
	 * 后序遍历
	 * 左子树
	 * 右子树
	 * 根节点
	 * @param binaryTree
	 */
	public void afterTraverse(Node binaryNode){
		preTraverse(binaryNode.left);
		preTraverse(binaryNode.right);
		System.out.println(binaryNode.value);
	}
	/**
	 * 递归查找
	 * @param binaryNode
	 * @param key
	 * @return
	 */
	public Node recusiveFind(Node binaryNode,int key){
		if(key < binaryNode.value){
			recusiveFind(binaryNode.left,key);
		}else if(key > binaryNode.value){
			recusiveFind(binaryNode.right,key);
		}else{
			return binaryNode;
		}
		return null;
	}
	/**
	 * 非递归 查找
	 * @param binaryNode
	 * @param key
	 * @return
	 */
	public Node noRecusiveFind(Node binaryNode,int key){
		while(binaryNode != null){
			if(key < binaryNode.value){
				binaryNode = binaryNode.left;
			}else if(key > binaryNode.value){
				binaryNode = binaryNode.right;
			}else{
				return binaryNode;
			}
		}
		return null;
	}
	/**
	 * 查找最大的值
	 * @param binaryNode
	 * @return
	 */
	public Node findMax(Node binaryNode){
		while(binaryNode.right != null){
			binaryNode = binaryNode.right;
		}
		return binaryNode;
	}
	/**
	 * 查找最小的值
	 * @param binaryNode
	 * @return
	 */
	public Node findMin(Node binaryNode){
		while(binaryNode.left != null){
			binaryNode = binaryNode.left;
		}
		return binaryNode;
	}
	
	/**
	 * 查找前驱
	 * 是该节点的左子树中的最大节点。
	 * 
	 * 定义 查找 小于当前节点的 最大节点
	 * @param binaryNode
	 * @return
	 */
	public Node findPrecursor(Node binaryNode){
		Node left = binaryNode.left;
		while(left.right != null){
			left = left.right;
		}
		return left;
	}
	/**
	 * 查找后驱
	 * 是该节点的右子树中的最小节点。
	 * 
	 * 定义： 查找大于当前节点的最小节点
	 * @param binaryNode
	 * @return
	 */
	public Node findAfterTheFlooding(Node binaryNode){
		Node right = binaryNode.right;
		while(right.left != null){
			right = right.left;
		}
		return right;
	}
	
}
