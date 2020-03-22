package com.algorithm.base;


import java.util.Stack;
import java.util.TreeMap;

/**
 * 二叉树
 */
public class BinaryTree {


    class Node {

        int value;

        Node left;//左节点

        Node right;//右节点

        Node parent;//父节点


        Node(int value,Node parent,Node left,Node right){
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
//        @Override
//        public int compareTo(Node o) {
//            return this.value - o.value;
//        }


    }
    Node root;

    /**
     * 插入节点
     * 如果根节点不存在，则插入节点作为根节点
     * 如果根节点存在，则比较插入节点和根节点的大小。
     *  小于根节点，则在左分支上进行操作
     *  大于根节点，在则右分支上进行操作
     * @param val
     * @return
     */
    public boolean insert(int val){
        Node insertNode = new Node(val, null, null, null);
        if(null == root){
            root = insertNode;
            return true;
        }
        Node node = root;
        while(true){
            if(node.value == val){
                return false;
            }else if(node.value > val){
                if(node.left == null){
                    node.left = insertNode;
                    insertNode.parent = node;
                    return true;
                }
                node= node.left;
            }else if(node.value < val){
                if(node.right == null){
                    node.right = insertNode;
                    insertNode.parent = node;
                    return true;
                }
                node = node.right;
            }
        }
    }
    /**
     * 删除节点
     */
    public boolean remove(int val){
        return  false;
    }

    /**
     * 查询值等于val的节点
     * @param val
     * @return
     */
    public Node search(int val){
        if(null == root){
            return null;
        }
        Node node = root;
        while(node.value != val){
            if(node.value > val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return node;
    }

    /**
     * 查询节点的前驱节点
     * 前驱节点定义:小于当前节点的最大节点。（在小于当前节点的所有节点中，取一个最大的节点）
     *  如果当前节点有左子树，则从左子树中找一个最大节点即可。
     *  如果当前节点没有左子树，则要分以下两种情况讨论：
     *      当前节点是其父节点的右子树，则当前节点的父节点即为前驱节点
     *      当前节点是其父节点的左子树，向上查找父节点是祖父节点的右子树。则祖父节点为前驱节点
     *          如果当前节点的父节点是祖父节点的右孩子，则祖父节点是前驱节点；如果不是，则以父节点为当前节点，继续向上找
     *
     * @param node
     * @return
     */
    public Node precursor(Node node){
        if(null == node){
            return null;
        }
        if(node.left != null){
            return maximum(node.left);
        }
         /*if(node.parent == null){
            return null;
        }
       Node parent = node.parent;
        if(parent.right == node){
            return parent;
        }

        if(parent.left == node){
            while(null != parent.parent && parent.parent.right != parent){
                parent = parent.parent;
            }
        }*/

        Node curNode = node;
        while(curNode.parent != null && curNode.parent.left == curNode){
            curNode = curNode.parent;
        }

       return curNode.parent;
    }

    /**
     * 查找节点的后继节点。
     * 后继节点定义:大于当前节点的最小节点。即从大于当前节点的节点中，找一个最小的
     *  如果节点有右子树，则从右子树中找一个这样的节点
     *  如果当前节点是父节点的左子树，则父节点就是后继节点
     *  如果当前节点是父节点的右子树。以当前节点的父节点为操作节点，找当前操作节点是父节点左子树的父节点，则此父节点是后继节点
     *
     *
     * @param node
     */
    public Node succeed(Node node){
        if(null == node){
            return null;
        }
        if(null != node.right){
            return minimum(node.right);
        }

        Node curNode = node;
        while(curNode.parent != null && curNode.parent.right == curNode){
            curNode = curNode.parent;
        }
        return curNode.parent;

    }

    /**
     * 查找以给定节点为根节点树的最大值
     * @param node
     * @return
     */
    public Node maximum(Node node){
        if(null == node){
            return null;
        }

        Node rightNode = node;
        while(rightNode.right != null){
            rightNode = rightNode.right;
        }
        return rightNode;
    }

    /**
     * 查找以给定节点为根节点树的最小值
     * @param node
     * @return
     */
    public Node minimum(Node node){
        if(null == node){
            return null;
        }
        Node leftNode = node;
        while(leftNode.left != null){
            leftNode = leftNode.left;
        }
        return leftNode;
    }

    /**
     * 前序遍历-递归的方式实现
     * 前序遍历根节点
     * 前序遍历左子树
     * 前序遍历右子树
     */

    public void preOrderRecursive(Node node){
        if(null != node){
            System.out.println(node.value);
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    /**
     * 前序遍历-非递归的方式实现
     * 前序遍历根节点
     * 前序遍历左子树
     * 前序遍历右子树
     */

    public void preOrderNoRecursive(Node node){
      /*  if(node == null){
            return;
        }*/
        Stack<Node> stack = new Stack<>();
      /*  while(true){
            if(node == null){
                return;
            }
            System.out.println(node.value);
            stack.push(node);
            node = node.left;
//            stack.pop()
            if(node == null){
                node = stack.pop();
                node = node.right;
            }

        }*/
      //应该把左节点给弹出来
        while(node != null){
            System.out.println(node.value);
            stack.push(node);
            node = node.left;
//            stack.pop()
            if(node == null){
                node = stack.pop();
                if(null != node.right){
                    node = node.right;
                }else{
                    node = stack.pop();
                }
            }
            //一直是

        }



    }

    /**
     * 中序递归遍历
     * 中序遍历左子树
     * 中序遍历根节点
     * 中序遍历右子树
     */
    public void infixOrderRecursive(Node node){
        if(null != node){
            infixOrderRecursive(node.left);
            System.out.println(node.value);
            infixOrderRecursive(node.right);
        }

    }

    /**
     * 中序遍历非递归实现
     * @param node
     */
    public void infixOrderNoRecursive(Node node){



    }

    /**
     * 后序算法递归遍历
     * 后序遍历左子树
     * 后序遍历右子树
     * 后序遍历根节点
     */
    public void afterOrderRecursive(Node node){
        if(null != node){
            afterOrderRecursive(node.left);
            afterOrderRecursive(node.right);
            System.out.println(node.value);
        }
    }

    /**
     * 节点删除
     *  如果当前节点只有一个子节点，则用子节点进行替换就可以了
     *  如果当前节点有两个子节点，则需要查找当前节点的后继节点
     * @param node
     * @return
     */
    public boolean remove(Node node){
        if(node == null){
            return false;
        }
        Node repalaceNode;
        if(node.left == null || node.right == null){//说明要删除的节点只有一个子节点
            repalaceNode = node;
        }else{//同时存在左右两个子节点
            repalaceNode = succeed(node);
        }
        Node tmpNode = null;
        if(repalaceNode.left != null){
            tmpNode = repalaceNode.left;
        }else if(repalaceNode.right != null){
            tmpNode = repalaceNode.right;
        }

        if(null != tmpNode){
            tmpNode.parent = repalaceNode.parent;
        }
        if(tmpNode.parent == null){//说明替换节点是一个根节点
            root = tmpNode;
        }else if(tmpNode.parent.left == repalaceNode){
            tmpNode.parent.left = tmpNode;
        }else if(tmpNode.parent.right == tmpNode){
            tmpNode.parent.right = tmpNode;
        }
        if(repalaceNode.value != node.value){
            node.value = repalaceNode.value;
        }
        return true;

    }


}
