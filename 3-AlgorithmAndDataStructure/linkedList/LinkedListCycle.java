/**
 * @author: Peter
 * @date: 30/12/2021
 * @description: https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // 使用快慢指针， fasterPointer走两步， slowPointer走一步， 当fastPointer == slowPointer时候 说明有cycle，
        // 若是fasterPointer==null 二者还未相遇 则没有cycle

        ListNode fastPointer = head, slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (slowPointer == fastPointer) return true;

        }

        return false;
    }
}
