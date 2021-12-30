/**
 * @author: Peter
 * @date: 30/12/2021
 * @description:
 */
public class FindCycleNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // 先用快慢指针找到环在哪
        ListNode fastPointer = head, slowPointer = head;

        while (fastPointer != null && fastPointer.next != null ) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (slowPointer == fastPointer) {
                ListNode ptr = head;
                while (ptr != slowPointer) {
                    ptr = ptr.next;
                    slowPointer = slowPointer.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
