package com.algorithm.base;

import java.util.ArrayList;

/**
 * 单向链表
 */
public class SinglyLinkedList<V> {

    class Node<V>{
        private V value;

        private Node<V> next;

        Node(V val,Node next){
            this.value = val;
            this.next = next;
        }

        Node(V val){
            this.value = val;
        }


        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<V> getNext() {
            return next;
        }

        public void setNext(Node<V> next) {
            this.next = next;
        }
    }
    public Node<V> tail = null;
    public Node<V> head = new Node<>(null,tail);


    public boolean addVal(V val){
        Node<V> addNode = new Node<>(val);
        if(head.next == null){
            head.next = addNode;
            tail = addNode;
            return true;
        }
        tail.next = addNode;
        tail = tail.next;
        return true;
    }

    public boolean removeVal(V val){
        Node pre = head;
        Node next = head.next;
        while(null != next){
            if(next.value == val || next.value.equals(val)){
                pre.next = next.next;
                if(next == tail){
                    if(pre != head){
                        tail = pre;
                    }else if(pre == head){
                        tail = null;
                    }
                }
                return true;
            }
            pre = next;
            next = next.next;

        }
        return false;
    }

    public void foreach(){
        Node next = head.next;
        while(null != next){
            System.out.println(next.value);
            next = next.next;
        }
    }

    public static void main(String[] args){
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addVal(1);
        singlyLinkedList.addVal(5);
        singlyLinkedList.addVal(6);
        singlyLinkedList.foreach();
        System.out.println("==============");
        singlyLinkedList.removeVal(1);
        singlyLinkedList.removeVal(5);
        singlyLinkedList.removeVal(6);
        singlyLinkedList.foreach();
        System.out.println(singlyLinkedList.tail.value);



    }
}
