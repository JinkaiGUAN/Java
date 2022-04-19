package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ22TheLastNodeInLinkedList
 * Author:   Peter
 * Date:     19/04/2022 23:36
 * Description: 链表中倒数k个节点
 * History:
 * Version:
 */
public class JZ22TheLastNodeInLinkedList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * Or we can use stack to implement this idea.
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if (k == 0) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        int i = 0;
        while (i < k && fast != null) {
            fast = fast.next;
            i += 1;
        }

        if (k - i >= 1) {
            return null;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
