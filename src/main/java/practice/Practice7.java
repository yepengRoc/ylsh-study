package practice;

public class Practice7 {

    class Node{
       int val;

       Node next;

       Node rand;
    }
    Node head;

    /**
     * 反转单链表
     *
     *  a b c d
     *  a - null
     *  b - a - null
     *
     *
     */
    public  void fanzhuan(Node head){

        Node tmpNode = head;

        Node newHead = null;
        Node cur = head;
        Node next = null;
        while(cur.next != null){
             next = cur.next;

             cur.next = newHead;
             newHead = cur;

             cur = next;

        }
        cur.next = newHead;
    }


    /**
     * 判断链表是否是回文结构
     *
     * 可以用栈
     *
     * 解法2 使用自身结构进行处理
     * 首先 找到中间节点 一次 走两步 和一次走一步。找到中间节点
     */

    /**
     * 链表的荷兰国旗问题 。
     * 分成左边小 中间相等 右边大
     */
    /**
     * 复制含有随机节点的链表
     */

    public void copyLinkList(Node head){

        Node cur1 = head;
        while(cur1 != null){
            Node copy = new Node();
            copy.val = cur1.val;
            copy.rand = cur1.rand;

            copy.next = cur1.next;
            cur1.next = copy;
            cur1 = copy.next;
        }


        Node copyHead = head.next;
        Node cur2 = head;
        Node copyCur = copyHead;
        while(copyCur != null){

            copyCur.rand = cur2.rand == null ? null : cur2.rand;
            cur2 = copyCur.next;
            copyCur = cur2 == null ? null : cur2.next;
        }

        cur2 = head;
        copyCur = copyHead;

        while(copyCur != null){
            cur2.next = copyCur.next;
            cur2 = cur2.next;
            if(cur2 != null){
                copyCur = null;
            }else{
                copyCur.next = cur2.next;
                copyCur = cur2.next;
            }
        }


        /**
         * 两链表相交。可能有环 TODO  --需要回锅
         */


    }

}


