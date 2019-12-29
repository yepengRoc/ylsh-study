package com.ylsh.study.leetcode;

import com.ylsh.study.datastruct.linkList.OneWayLinkedList;

/**
 * 两个单向链表
 * input 2->4->3 + 5->6->4
 * output  7-》0-》8
 * time o(n)
 * space o(n)
 */
public class Lc002 {

    public ListNode addTwoNums(ListNode l1,ListNode l2){
        ListNode rtnNode = new ListNode(0);

        ListNode cur = rtnNode;
        int sum = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null || p2 != null){
            if(null != p1){
                sum = sum + p1.val;
                p1 = p1.next;
            }
            if(null != p2){
                sum = sum + p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum = sum / 10;
            cur = cur.next;

        }
        //如果sum还有值，说明链表的最后一项相加有进位
        if(sum > 0){
            cur.next = new ListNode(sum);
        }

        return rtnNode;
    }
}
