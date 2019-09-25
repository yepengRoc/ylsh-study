package com.ylsh.study.datastruct.linkList;

import java.util.Date;

/**
 * 单向循环链表
 */
public class OneWayCircularLinkedList<T> {
    /**
     * 头节点
     */
    private DataNode head ;

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
            return false;
        }
        DataNode addNode = new DataNode(t, null);
        if(null == head){
            head = new DataNode(null, null);
            head.next = head;
        }
        addNode.next = head.next;
        head.next = addNode;
        return true;
    }

    private boolean remove(T t){
         if(null == t){
             return false;
         }
        DataNode pre = head;
         DataNode data;
         while((data = head.next) != head){
            if(t == data.value){
                return true;
            }
             pre = data;
         }
         return false;
    }
}
