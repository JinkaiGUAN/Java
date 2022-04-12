package main.com.peter.java.easy;

import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ9ImplementQueueUsingStacks
 * Author:   Peter
 * Date:     12/04/2022 23:24
 * Description: https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ9ImplementQueueUsingStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
