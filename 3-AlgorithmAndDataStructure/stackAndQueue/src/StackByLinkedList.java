/**
 * @author: Peter
 * @date: 31/12/2021
 * @description:
 */
public class StackByLinkedList {
    public static class StackNode {
        int val;
        StackNode next;

        StackNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    StackNode top;

    public StackByLinkedList() {
        top = null;
    }

    public void push(int val) {
        StackNode newNode = new StackNode(val);

        if (top == null) {
            top = newNode;
        } else {
            StackNode temp = top;
            top = newNode;
            newNode.next = temp;
        }
        System.out.println(val + " is pushed to stack.");
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return Integer.MIN_VALUE;
        }
        int popped = top.val;
        top = top.next;

        return popped;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return Integer.MIN_VALUE;
        }

        return top.val;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
