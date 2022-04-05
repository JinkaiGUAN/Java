import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: TrappingRainWater
 * Author:   Peter
 * Date:     05/04/2022 12:02
 * Description: https://leetcode-cn.com/problems/trapping-rain-water/
 * History:
 * Version:
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            // 第一个和最后一个柱子不记录

            if (height[i] > height[stack.peek()]) {
                // 下一个元素大于栈顶元素
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();

                    if (!stack.isEmpty()) {
                        int h = Math.min(height[stack.peek()], height[i])  - height[mid];
                        int w = i - stack.peek() - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            res += h * w;
                        }
                    }
                }
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                // 下一个元素等于栈顶元素
                stack.pop();
                stack.push(i);
            } else {
                // 下一个元素小于栈顶元素
                stack.push(i);
            }
        }

        return res;
    }

}
