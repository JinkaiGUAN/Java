import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * @author: Peter
 * @date: 01/01/2022
 * @description: https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        //"([)]" 使用栈结构，构造一个集合， 包含左括号， 一次压入栈， 遇到右括号， 弹出栈顶元素， 若是与当前右括号匹配， 则继续， 否则返回
        // false， 同时使用字典构造左右括号对。
        if (s.length() % 2 == 1 || s.length() == 0) return false;

        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> parenthesesPair = new HashMap<Character, Character>();
        Set<Character> rightParenthesesSet = new HashSet<Character>(){{add('('); add('{'); add('[');}};

        parenthesesPair.put(']', '[');
        parenthesesPair.put('}', '{');
        parenthesesPair.put(')', '(');

        for (int i = 0; i < s.length(); i++) {
            char singleParentheses = s.charAt(i);
            if (rightParenthesesSet.contains(singleParentheses)) {
                stack.add(singleParentheses);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char singleRightParentheses = stack.pop();
                    char singleMatchRight = parenthesesPair.get(singleParentheses);
                    if (singleRightParentheses == singleMatchRight) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
