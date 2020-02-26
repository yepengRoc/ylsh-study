package com.algorithm.base;


import java.util.LinkedList;

/**
 * 双向链表
 */
public class DoubleLinkedList<V> {

    class Node<V>{
        public V value;

        public Node<V> next;

        public Node<V> pre;

        Node(V val,Node pre, Node next){
            this.value = val;
            this.pre = pre;
            this.next = next;
        }

        Node(V val){
            this.value = val;
        }

    }

    Node<V> head = new Node<>(null,null,null);

    Node<V> tail;

    public boolean addVal(V val){
        if(null == val){
            return false;
        }
        Node addNode = new Node(val,null,null);
        if(head.next == null){
            head.next = addNode;
            addNode.pre = head;
            tail = addNode;
            return true;
        }
        tail.next = addNode;
        addNode.pre = tail;
        tail = addNode;
        return true;
    }

    public boolean removeVal(V val){
        if(null == val){
            return false;
        }
        Node next = head.next;
        while(next != null){
            if(next.value == val || next.value.equals(val)){
                next.pre.next = next.next;
                if(tail == next){
                    if(next.pre == head){//最后一个节点
                        tail = null;
                    }else{
                        tail = next.pre;
                    }
                    return true;

                }
                next.next.pre = next.pre;
                return true;
            }
            next = next.next;
        }
        return false;
    }

    public void foreach(){
        Node next = head.next;
        while(next != null){
            System.out.println(next.value);
            next = next.next;
        }
    }


    
    
    public static void main(String[] args){
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.addVal(2);
        doubleLinkedList.addVal(9);
        doubleLinkedList.addVal(3);
        doubleLinkedList.addVal(7);

        doubleLinkedList.foreach();
        System.out.println("====");
        doubleLinkedList.removeVal(7);
        doubleLinkedList.removeVal(9);
        doubleLinkedList.foreach();
        System.out.println("=====");


    }
}
