package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ23TheEntrenceOfCircularLinkedList
 * Author:   Peter
 * Date:     20/04/2022 00:07
 * Description:
 * History:
 * Version:
 * @author Peter
 */

public class JZ23TheEntranceOfCircularLinkedList {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // make sure if it has circle
        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean flag = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                flag = true;
                break;
            }
        }

        // consider the bound: only one and two element and the head is null;
        if (!flag) {
            return null;
        }

        // find the entrence
        slow = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}