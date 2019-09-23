package com.ylsh.study.datastruct.linkList;

/**
 * 单向链表
 */
public class OneWayLinkedList<T> {

    /**
     * 头节点
     */

    private Node header = new Node(null,null);
    /**
     * 尾节点
     */
    private Node tail;

    private int size = 0;

    /**
     * 这里采用头插法处理
     * @param t
     * @return
     */

    public Node add(T t){
        if(null == t){
            return null;
        }


        Node next = header.next;
        Node addNode = new Node(t,next);

        header.next = addNode;

        if(null == tail){
            tail = addNode;
        }
        size++;
        return addNode;

    }

    /**
     * 尾插法
     * @return
     */
    public Node tailAdd(T t){
        if(null == t){
            return null;

        }
        Node addNode = new Node(t,null);

        if(null == tail){
            tail = addNode;
        }
        tail.next = addNode;
        tail = addNode;
        size++;

        return tail;
    }

    private class Node<T>{
        private T value;

        private Node next;

        Node(T value,Node next){
            setValue(value);
            setNext(next);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
