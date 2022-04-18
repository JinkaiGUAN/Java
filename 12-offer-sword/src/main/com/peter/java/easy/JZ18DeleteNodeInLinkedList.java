package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ18DeleteNodeInLinkedList
 * Author:   Peter
 * Date:     18/04/2022 22:09
 * Description: https://www.nowcoder.com/practice/f9f78ca89ad643c99701a7142bd59f5d?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ18DeleteNodeInLinkedList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param val int整型
     * @return ListNode类
     */
    public ListNode deleteNode (ListNode head, int val) {
        // write code here

        ListNode originalHead = head;
        ListNode preNode = null;
        while (head != null) {
            if (head.val == val) {
                // delete the node
                if (preNode == null) {
                    // the deleting node is original head node
                    return head.next;
                } else {
                    ListNode deletedNode = head;

                    preNode.next = deletedNode.next;
                    // GC convinence
                    deletedNode.next = null;
                }
                break;
            }

            // update the node relationship
            preNode = head;
            head = head.next;
        }

        return originalHead;
    }
}
