package com.ylsh.study.books.sjjgysfzm.sty6;

import javax.xml.crypto.Data;

/**
 * 最近最少使用的进行淘汰
 * 新加入的数据存在两种情况：
 *  1已经在链表里存在，则进行删除，然后把数据放入链表头
 *  2数据在链表中没有存在，直接放入链表头
 *  这样表链表尾就是最不常用的数据。淘汰的时候从链表尾进行淘汰
 */
public class LRUCache {

    private int maxLen = 10;

    private int size = 0;//统计当前链表大小

    private DataNode head;//头节点

//    private DataNode tail;//尾节点

    private  class DataNode{
        public int value;

        public DataNode next;

        DataNode(int value,DataNode dataNode){
            this.value = value;
            this.next = dataNode;

        }
    }

    /**
     *
     * @param value
     * @return
     */
    public DataNode addData(int value){
        if(null == head){
            DataNode dataNode = new DataNode(value, null);
            head = dataNode;
            return dataNode;
        }
        DataNode preNode = null;
        DataNode node = head;
        while(node != null){
            if(node.value == value){
                if(preNode == null){
                    return node;
                }
                preNode.next = node.next;
                return new DataNode(value, head);
//                return node;
            }
            preNode = node;
            node = preNode.next;
        }
        if(size == maxLen){//需要进行淘汰
            preNode = null;
            size--;
        }
        DataNode addData = new DataNode(value,head);
        size++;
        return addData;
    }

    public DataNode getDataNode(int value){
            return addData(value);
    }


}
