package main.com.peter.java.easy;

import main.com.peter.java.entity.ListNode;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ24ReverseLinkedList
 * Author:   Peter
 * Date:     20/04/2022 08:25
 * Description: https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=265&tqId=39226&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D265&difficulty=undefined
 * &judgeStatus=undefined&tags=&title=
 * History:
 * Version:
 */
public class JZ24ReverseLinkedList {
    public ListNode ReverseList(ListNode head) {

        ListNode pre = null;
        ListNode post = null;

        while (head != null) {
            post = head.next;

            // point reverse
            head.next = pre;
            pre = head;

            // update head
            head = post;
        }

        return pre;
    }
}
