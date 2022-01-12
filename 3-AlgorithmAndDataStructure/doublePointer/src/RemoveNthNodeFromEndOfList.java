/**
 * @author: Peter
 * @date: 12/01/2022
 * @description:
 */
public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用双指针， 先让快指针移动n 步， 之后快慢指针一起移动， 然后删除慢指针指定位置
        ListNode dummyHead = new ListNode(-1, head);

        ListNode slowPtr = dummyHead, fastPtr = dummyHead;

        while (n-- > 0) {
            fastPtr = fastPtr.next;
        }

        ListNode pre = null;
        while (fastPtr != null) {
            pre = slowPtr;
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        pre.next = slowPtr.next;
        slowPtr.next = null;

        return dummyHead.next;
    }
}
