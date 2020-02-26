package com.algorithm.base;


/**
 * 双向循环链表
 */
public class DoubleCircularLinkedList<V> {

    class Node<V>{
        public V value;

        public Node<V> next;

        public Node<V> pre;

        Node(V val, Node pre, Node next){
            this.value = val;
            this.pre = pre;
            this.next = next;
        }

        Node(V val){
            this.value = val;
        }

    }

    Node<V> head = new Node<>(null,null,null);


    public boolean addVal(V val){
        if(null == val){
            return false;
        }
        Node addNode = new Node(val,null,null);
        if(head.next == null){
            head.next = addNode;
            head.pre = addNode;
            addNode.next = head;
            addNode.pre = head;
            return true;
        }

        addNode.pre = head.pre;
        addNode.next = head.pre.next;

        head.pre.next = addNode;
        head.pre = addNode;
        return true;

    }

    public boolean removeVal(V val){
        if(null == val){
            return false;
        }
        Node next = head.next;
        while(next != null && next.value != null){
            if(next.value == val || next.value.equals(val)){
                next.pre.next = next.next;
                next.next.pre = next.pre;
                next.next = next.pre = null;
                return true;
            }
            next = next.next;
        }
        return false;
    }

    public  void foreach(){
        Node next = head.next;
        while(next != null && next.value != null){
            System.out.println(next.value);
            next = next.next;
        }
    }


    public static void main(String[] args){
        DoubleCircularLinkedList<Integer> doubleCircularLinkedList = new DoubleCircularLinkedList<>();
        doubleCircularLinkedList.addVal(3);
        doubleCircularLinkedList.addVal(8);
        doubleCircularLinkedList.addVal(6);
        doubleCircularLinkedList.addVal(5);
        doubleCircularLinkedList.foreach();
        System.out.println("====");
        doubleCircularLinkedList.removeVal(8);
        doubleCircularLinkedList.removeVal(5);
        doubleCircularLinkedList.foreach();
    }
}
