package src;

import java.util.Stack;

/**
 * @author: Peter
 * @date: 15/01/2022
 * @description: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        // 用stack实现， 如果peek元素与即将入栈元素相同， 那么出栈， 否则入栈
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(letter);
            } else if (stack.peek().equals(letter)){
                stack.pop();
            } else {
                stack.push(letter);
            }
        }

        return stack.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(", ", "");
    }

//    public String removeDuplicate(String s) {}
}
