/**
 * @author: Peter
 * @date: 12/01/2022
 * @description: https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class FindCrossPointInTheListNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;

        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }

        return curA;

    }

    public static void main(String[] args) {
        ListNode a = null;
        ListNode b = null;
        System.out.println(a ==b);
    }

}
