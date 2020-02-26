package com.algorithm.base;

/**
 * 单向循环链表
 */
public class SinglyLinkedCircularList<V> {

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
    public Node<V> head = new Node<>(null,null);

    public Node<V> tail = null;

    public boolean addVal(V val){
        if(null == val){
            return false;
        }
        Node<V> addNode = new Node(val);
        if(null == head.next){
            head.next = head;
            addNode.next = head.next;
            head.next = addNode;
            tail = addNode;
            return true;
        }
        addNode.next = tail.next;
        tail.next = addNode;
        tail = addNode;
        return true;
    }

    public boolean removeVal(V val){
        if(null == val){
            return false;
        }
        Node pre = head;
        Node next = head.next;
        while(next.value != null){
            if(next.value == val || next.value.equals(val)){

                pre.next = next.next;
                if(next == tail && pre != head){
                    tail = pre;
                }
                if(pre.next == head){
                    tail = null;
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
        while(next != head){
            System.out.println(next.value);
            next = next.next;
        }
    }

    public static void main(String[] args){
        SinglyLinkedCircularList<Integer> singlyLinkedCircularList = new SinglyLinkedCircularList();

        singlyLinkedCircularList.addVal(1);
        singlyLinkedCircularList.addVal(7);
        singlyLinkedCircularList.addVal(8);

        singlyLinkedCircularList.foreach();
        System.out.println("===");
        singlyLinkedCircularList.removeVal(8);
        singlyLinkedCircularList.removeVal(1);
        singlyLinkedCircularList.foreach();
        System.out.println("===");
    }


}
