import java.util.Stack;
import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: NextGreaterElementII
 * Author:   Peter
 * Date:     05/04/2022 11:19
 * Description: https://leetcode-cn.com/problems/next-greater-element-ii/submissions/
 * History:
 * Version:
 * @author Peter
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length * 2; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                // 替换元素
                res[stack.peek()] = nums[i % nums.length];

                // 移除栈顶元素
                stack.pop();
            }

            stack.push(i % nums.length);
        }

        return res;
    }
}
