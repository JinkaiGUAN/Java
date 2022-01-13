package src;

import java.util.Queue;
import java.util.LinkedList;


/**
 * @author: Peter
 * @date: 31/12/2021
 * @description:
 */
public class ImplementStackUsingQueue {
    //使用linkedlist时， 我们只能用addLast and getFirst methods
    // 一个队列在模拟栈弹出元素的时候只要将队列头部的元素（除了最后一个元素外） 重新添加到队列尾部，此时在去弹出元素就是栈的顺序了。
    // todo: Using one queue to accomplish this structure.

    private Queue<Integer> queue1; // 作为主要队列
    private Queue<Integer> queue2; // 作为备份队列

    public ImplementStackUsingQueue() {
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if (empty()) {
            System.out.println("The stack is empty!");
            return Integer.MIN_VALUE;
        }

        // stack is not empty, we need to push the elements in the queue1 to queue2, but keep the last elements in the
        // queue1.
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int poppedEle = queue1.remove();

        // reback the elements to queue1 in queue2
        while (queue2.size() > 0) {
            queue1.add(queue2.remove());
        }

        return poppedEle;
    }

    public int top() {
        if (empty()) {
            System.out.println("The stack is empty!");
            return Integer.MIN_VALUE;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int peekEle = queue1.peek();
        queue2.add(queue1.remove());

        // reback the elements to queue1 in queue2
        while (queue2.size() > 0) {
            queue1.add(queue2.remove());
        }

        return peekEle;
    }

    public boolean empty() {
        return queue1.size() == 0;
    }
}
