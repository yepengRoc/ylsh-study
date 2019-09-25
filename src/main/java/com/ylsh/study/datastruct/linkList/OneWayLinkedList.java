package com.ylsh.study.datastruct.linkList;

import javax.xml.crypto.Data;

/**
 * 单向链表
 */
public class OneWayLinkedList<T> {

    /**
     * 头节点
     */

    private Node header ;
//    private Node tail ;

    private int size = 0;

    /**
     * 这里采用头插法处理
     * @param t
     * @return
     */

    public boolean add(T t){
        if(null == t){
            return false;
        }
        Node addNode = new Node(t,null);
        if(null == header){
            header = new Node(null, null);
//            tail = addNode;
        }
        addNode.next = header.next;
        header.next = addNode;
        size++;
        return true;

    }

    /**
     * 指定位置插入
     * @param index
     * @param t
     * @return
     */
    public boolean add(int index,T t){
        if(index > size || index < 0 || t == null){
            return false;
        }
        Node addNode = new Node(t, null);
        Node pre = header;
        Node node;
        int i = 0;
        while((node = header.next) != null){
            if(i == index){
              break;
            }
            pre = node;
            i++;
        }
        addNode.next = pre.next;
        pre.next = addNode;
        return true;
    }


    public boolean remove(T t){
        if(null == t){
            return false;
        }
        //记录前一个节点
        Node pre = header;
        Node data;
        while((data = header.next) != null){
            if(t == data.value){
                pre.next = data.next;
                return true;
            }
            pre = data;
        }
        return false;

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
