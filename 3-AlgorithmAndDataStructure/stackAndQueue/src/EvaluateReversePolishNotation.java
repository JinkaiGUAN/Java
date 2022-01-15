package src;

import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;


/**
 * @author: Peter
 * @date: 15/01/2022
 * @description: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // 使用栈来解决， 入栈之后， 只要没有运算符继续入栈， 如果碰到运算符， 出栈两次， 但是我们需要考虑元素是否为空.
        // 使用Integer.parseInt（）将string 变为int. operator可直接与字符串比较
        // 注意， 是否需要考虑一个ele的情况
        Stack<Integer> stack = new Stack<>();
        Set<String> operatorSet = new HashSet<>();
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("*");
        operatorSet.add("/");

        for (String ele: tokens) {
            if (operatorSet.contains(ele)) {
                // 我们默认输入的逆波兰表达式都有效， 即出现一个operator时， 我们的stack当中有两个元素
                int firstNum = stack.pop(), secondNum = stack.pop();
                // todo: do the calculation
                int res = switch (ele) {
                    case "+" -> firstNum + secondNum;
                    case "-" -> secondNum - firstNum;
                    case "*" -> firstNum * secondNum;
                    default -> secondNum / firstNum;
                };

                stack.push(res);
            } else {
                // 输入时数字
                stack.push(Integer.parseInt(ele));
            }
        }

        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        int n = tokens.length;
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
