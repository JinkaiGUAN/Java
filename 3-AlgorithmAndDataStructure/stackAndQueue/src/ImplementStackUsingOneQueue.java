package src;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: Peter
 * @date: 13/01/2022
 * @description:
 */
public class ImplementStackUsingOneQueue {
    // This class will implement a simple stack structure using one queue

    private Queue<Integer> queue;

    public ImplementStackUsingOneQueue() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        // if the stack is empty, return a really small value. Otherwise, pop out the peek value.
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return Integer.MIN_VALUE;
        }

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }

        return queue.remove();
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return Integer.MIN_VALUE;
        }

        for (int i = 0; i < queue.size() - 1; i ++) {
            queue.add(queue.remove());
        }

        int peek = queue.remove();
        queue.add(peek);

        return peek;
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }
}
