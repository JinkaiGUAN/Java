package main.com.peter.java.easy;

import main.com.peter.java.entity.ListNode;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ52FindFirstCommonNode
 * Author:   Peter
 * Date:     30/04/2022 16:16
 * Description: https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ52FindFirstCommonNode {
    /**
     * list1 : [1, 2, 3, 6, 7]
     * list2 : [4, 5, 6, 7]
     * merge: [1, 2, 3, 6, 7, 4, 5, 6, 7]
     * merge: [4, 5, 6, 7, 1, 2, 3, 6, 7]
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // merge two list
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;

        while (cur1 != cur2) {
            cur1 = (cur1 == null ? pHead2 : cur1.next);
            cur2 = (cur2 == null ? pHead1 : cur2. next);
        }

        return cur1;
    }
}
