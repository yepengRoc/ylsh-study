package com.ylsh.study.books.book7;

public class LinkedList {
    class Node{
        public int value;
        public Node next;

    }
    public Node head = null;

    /**
     * 插入
     * @param value
     */
    public void insert(int value){
        Node insertNode = new Node();
        insertNode.value = value;

        if(head == null){
            head = insertNode;
        }else{
            Node tempNode = head;
            Node nextNode = null;
            while((nextNode = tempNode.next) != null){
                tempNode = tempNode.next;
            }
            tempNode.next =  insertNode;
        }
    }

    public void delete(int value){
        if(head == null){
            return;
        }else{
            Node pNode = head;
            Node nextN = pNode;

            /*while(pNode != null && pNode.value != value){
                pNode = pNode.next;
            }*/
//            Node nextN = pNode.next;
            while(nextN != null && nextN.value != value){
                pNode = nextN;
                nextN = pNode.next;
            }
//            pNode.next = nextN.next;
            //等于 null说明没有要删除的数
            if(nextN != null){
                if(nextN.next == null){//说明是最后一个
                    pNode.next = null;
                }else{
                    pNode.next = nextN.next;
                }

            }
        }
    }
}
