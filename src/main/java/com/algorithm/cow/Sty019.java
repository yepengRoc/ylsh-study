package com.algorithm.cow;

import java.awt.dnd.DnDConstants;

/**
 * 翻转单向链表
 */
public class Sty019 {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(9);
        linkList.add(8);
        linkList.add(23);
        linkList.add(45);

        linkList.printData();
        System.out.println("================");
        reverseLinkList(linkList);

        linkList.printData();
    }

    public static void reverseLinkList(LinkList linkList){
        if(null == linkList){
            return;
        }
        Node cur = linkList.head.next;
        Node pre = null;
        Node next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        linkList.head.next = pre;//恢复哨兵节点


    }
}
class Node{
    int data;
    Node next;
    Node(){

    }
    Node(int data,Node next){
        this.data = data;
        this.next = null;
    }
}

class LinkList{


    Node head = new Node();//哨兵节点

    public void add(int value){
        Node addNode = new Node(value,null);

        //头插法
        addNode.next = head.next;
        head.next = addNode;
    }

    public void printData(){
        Node h = head;

        while ( h.next != null){
            h = h.next;
            System.out.println(h.data);
        }
    }
}
//双向链表简单一些
class DNode{

    int data;

    DNode pre;

    DNode next;

    DNode(){

    }

    DNode head;

    DNode tail;

}
