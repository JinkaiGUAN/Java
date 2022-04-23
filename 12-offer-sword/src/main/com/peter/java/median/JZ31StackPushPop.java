package main.com.peter.java.median;

import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ31StackPushPop
 * Author:   Peter
 * Date:     23/04/2022 15:05
 * Description: https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=265&tqId=39233&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ31StackPushPop {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            if (pushA[i] != popA[j]) {
                stack.push(pushA[i++]);
            } else {
                ++i;
                ++j;

                while (!stack.isEmpty() && stack.peek() == popA[j]) {
                    stack.pop();
                    ++j;
                }
            }
        }

        return stack.isEmpty();
    }
}
