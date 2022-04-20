package main.com.peter.java.easy;

import main.com.peter.java.entity.ListNode;

import java.util.Collections;
import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ6PrintLinkedListReversely
 * Author:   Peter
 * Date:     10/04/2022 22:41
 * Description: https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ6PrintLinkedListReversely {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        System.out.println(printListFromTailToHead(node1));
    }
}