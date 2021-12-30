/**
 * @author: Peter
 * @date: 30/12/2021
 * @description:
 */
public class ReverseLinkedList {

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

    public ListNode reverseList(ListNode head) {
        // 吸纳让head指向null， cur pointer 移动到head next

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;

            // move the node
            cur = nextNode;

        }

        return prev;
    }

}
