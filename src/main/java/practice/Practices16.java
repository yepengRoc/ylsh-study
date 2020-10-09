package practice;



/**
 * 二叉树的神级遍历
 */
public class Practices16 {



}


class Tree16{

    class Node{
        Node left;

        Node right;

        int data;
    }

    Node root;

    public void preBianli(Node root){

    }

    /**
     * 标记是  前序 中序 还是后序
     * 先序 去掉第一次出现的节点
     * 中序 去掉第二次出现的节点
     * @param root
     * @param flag
     */
    public void bianli(Node root,int flag){

        Node cur = root;

        while(cur != null){

            if(cur.left == null){

                cur = cur.right;
            }else{
                Node mostRight = cur.left;

                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;//继续往下遍历
                }else{
                    cur = cur.right;//这个时候 cur 就是 mostRight节点
                    mostRight.right = null;//重置为null
                }

            }
        }

    }

    public void afterBianli(Node root){
        if(root == null){
            return;
        }
        Node cur = root;
        while(null != cur){
            if(null == cur.left){
                cur = cur.left;
            }else{
                Node mostRight = cur.left;
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }else{

                    mostRight.right = null;
                    pirntRihtEdge(cur.left);
                    cur = cur.right;
                }
            }
        }
        pirntRihtEdge(root);
    }

    public void pirntRihtEdge(Node root){
        if(null == root){
            return;
        }

        Node cur = root;
        Node pre = null;
        while(null != cur){
            Node next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }

        cur = pre;

        while(null != cur){
            System.out.println(cur.data);
            cur = cur.right;
        }

        cur = pre;
        pre = null;
        while(cur != null){
           Node next = cur.right;
           cur.right = pre;
           pre.right = cur;
           cur = next;
        }

    }


}
