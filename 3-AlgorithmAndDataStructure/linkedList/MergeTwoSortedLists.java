/**
 * @author: Peter
 * @date: 30/12/2021
 * @description: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 新生成一个地址， 找出头节点最小， 然后while loop，在后一个链表呗循环结束后， 另一个链表直接房子啊新链表之后

        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode newList = new ListNode(0);
        ListNode ans = newList;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                newList.next = cur1;
                cur1 = cur1.next;
            } else {
                newList.next = cur2;
                cur2 = cur2.next;
            }
            newList = newList.next;
        }

//        if (cur1 == null && cur2 != null) {
//            newList.next = cur2;
//        } else if (cur1 != null && cur2 == null) {
//            newList.next = cur1;
//        }

        newList.next = cur2 == null ? cur1 : cur2;

        return ans.next;
    }

}
