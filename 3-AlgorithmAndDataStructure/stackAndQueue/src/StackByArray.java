/**
 * @author: Peter
 * @date: 31/12/2021
 * @description:
 */
public class StackByArray {
    static final int CAPACITY = 1000;
    int top; // key thing in the  stack, it is used to record the position of the peek element.
    int[] stack;

    public StackByArray() {
        this.top = -1;
        stack = new int[CAPACITY];
    }

    // 在push过程中要检查是否达到最大容量， 如果是暑促溢出栈， 否则移动top指针
    public boolean push(int val) {
        if (top >= (CAPACITY - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        stack[++top] = val;
        return true;
    }

    // 需要检查stack是否为空， 如果是， 输出栈下溢错误
    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow.");
            return 0;
        }
        return stack[top--];
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow.");
            return 0;
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }
}
