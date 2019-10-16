package com.ylsh.study.datastruct.linkList;

/**
 * 双向链表。
 */
public class DoubleWayLinkedList <T>{
    /**
     * 头结点
     */
    private DataNode head;
    /**
     * 双向链表长度
     */
    private int length;
    DoubleWayLinkedList(){
        head = new DataNode(null, null, null);
    }
    class DataNode{
        private DataNode pre;

        private DataNode next;

        private T value;
        DataNode(DataNode pre,DataNode next,T value){
            this.pre = pre;
            this.next = next;
            this.value = value;
        }

        public DataNode getPre() {
            return pre;
        }

        public void setPre(DataNode pre) {
            this.pre = pre;
        }

        public DataNode getNext() {
            return next;
        }

        public void setNext(DataNode next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    /**
     * 添加元素
     * @param addData
     * @return
     */
    public boolean add(T addData){
        if(null == addData){
            return false;
        }
        DataNode addNode = new DataNode(null, null, addData);

        addNode.next = head.next;
        addNode.pre = head;

        addNode.next.pre = addNode;
        addNode.pre.next = addNode;

        length++;
        return true;
    }

    /**
     * 在指定位置添加
     * @param idx
     * @param addData
     * @return
     */
    public boolean add(int idx,T addData){
        if(idx > length || idx < 1 ){
            return false;
        }
        if(null == addData){
            return false;
        }
        DataNode next = null;
        int count = 0;
        while((next = head.next) != null){
            count++;
            if(count == idx){
                break;
            }
            count++;
        }
        if(null != next){
            DataNode addNode = new DataNode(null, null, addData);
            addNode.next = next.next;
            addNode.pre = next.pre;

            addNode.next.pre = addNode;
            addNode.pre.next = addNode;
            length++;
            return true;
        }
        return false;
    }

    public boolean remove(T value){
        if(null == value){
            return false;
        }
        DataNode next = null;
        while((next = head.next) != null){
            if(value.equals(next.getValue())){
                next.pre.next = next.next;
                next.next.pre = next.pre;
                next = null;
                length--;
                return true;
            }
        }
        return false;
    }

    /**
     * 移除指定位置的值
     * @param idx
     * @param value
     * @return
     */
    public boolean remove(int idx,T value){
        if(idx < 1 || idx > length){
            return false;
        }
        if(null == value){
            return false;
        }
        DataNode dataNode = null;
        int count = 1;
        while((dataNode = head.next) != null){
            if(count == idx){
                break;
            }
            count++;
        }
        if(null != dataNode){
            dataNode.pre.next = dataNode.next;
            dataNode.next.pre = dataNode.pre;
            dataNode = null;
            length--;
            return true;
        }
        return false;
    }
}
