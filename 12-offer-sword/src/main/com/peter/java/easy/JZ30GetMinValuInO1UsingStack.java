package main.com.peter.java.easy;

import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ30GetMinValuInO1UsingStack
 * Author:   Peter
 * Date:     22/04/2022 23:02
 * Description: https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ30GetMinValuInO1UsingStack {
    /**
     * The stack stores the elements;
     */
    private Stack<Integer> elementData = new Stack<>();

    /**
     * Stores the minimal data once pushing and popping out the elements.
     */
    private Stack<Integer> minElementData = new Stack<>();

    /**
     * the min val of the stack
     */
    private int minVal = Integer.MAX_VALUE;

    public void push(int node) {
        this.elementData.push(node);
        if (node < this.minVal) {
            this.minVal = node;
        }
        this.minElementData.push(this.minVal);

    }

    public void pop() {
        this.elementData.pop();
        this.minElementData.pop();

        if (this.minElementData.isEmpty()) {
            this.minVal = Integer.MAX_VALUE;
        } else {
            this.minVal = this.minElementData.peek();
        }
    }

    public int top() {
        return this.elementData.peek();
    }

    public int min() {
        return this.minElementData.peek();
    }
}
