package com.ylsh.study.datastruct.linkList;

import java.util.Date;

/**
 * 单向循环链表
 */
public class OneWayCircularLinkedList<T> {
    /**
     * 头节点
     */
    private DataNode head = new DataNode(null,null);
    /**
     * 尾节点
     */
    private DataNode tail;

    private int size;
    private class  DataNode<T>{
        private T value;

        private DataNode next;

        DataNode(T value,DataNode next){
            setValue(value);
            setNext(next);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public DataNode getNext() {
            return next;
        }

        public void setNext(DataNode next) {
            this.next = next;
        }
    }

    private boolean addNode(T t){
        if(null == t){
            return true;
        }
        DataNode addNode = new DataNode(t, null);
        if(null == head){
            tail = head = addNode;
            tail.next = head;
            return true;
        }
        addNode.next = tail.next;
        tail.next = addNode;
        return false;
    }

    private T remove(T t){
         if(null == head){
             return null;
         }
        DataNode data = head;
         while(true){

         }
         if(data.value == t || data.value.equals(t)){

         }
         return ;

    }
}
