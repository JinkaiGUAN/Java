import java.util.Stack;

/**
 * @author: Peter
 * @date: 31/12/2021
 * @description: https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {
    // 此时应该无需考虑大小: 我们使用两个stacks， 第一个stack 出栈到第二个stack， 然后油第二个stack出栈形成queue.
    // 只要out里面有元素， in只能继续接受元素， 而不能push到out中

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public ImplementQueueUsingStacks() {
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        // 在此之前要检查stack中是否有元素， 没有再去检查helpStack
        // 如果队列为空 返回极小值
        if (empty()) {
            System.out.println("The queue is empty");
            return Integer.MIN_VALUE;
        }

        // Check whether the stackout is empty or not, if it is empty, we push all elements in stackIn to stackOut.
        checkStackIn();

        return stackOut.pop();
    }

    public void checkStackIn(){
        // 如果队列不为空， out为空， in有值，出栈到out中
        if (!stackIn.isEmpty() && stackOut.isEmpty()) {

            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public int peek() {
        if (empty()) {
            System.out.println("The queue is empty");
            return Integer.MIN_VALUE;
        }

        checkStackIn();

        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

}
