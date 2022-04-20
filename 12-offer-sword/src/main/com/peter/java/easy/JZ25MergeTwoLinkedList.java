package main.com.peter.java.easy;

import main.com.peter.java.entity.ListNode;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ25MergeTwoLinkedList
 * Author:   Peter
 * Date:     20/04/2022 08:07
 * Description: https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=265&tqId=39227&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D265&difficulty=undefined
 * &judgeStatus=undefined&tags=&title=
 * History:
 * Version:
 */
public class JZ25MergeTwoLinkedList {

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // append the nodes
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }

            cur = cur.next;
        }

        // add the last part of node1 or node2
        cur.next = node1 == null ? node2 : node1;

        return dummyHead.next;
    }
}