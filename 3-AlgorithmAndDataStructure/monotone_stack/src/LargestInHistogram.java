import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: LargestInHistogram
 * Author:   Peter
 * Date:     06/04/2022 18:12
 * Description: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * History:
 * Version:
 */
public class LargestInHistogram {
    int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                // 注意是while
                while (heights[i] < heights[st.peek()]) {
                    System.out.println("cal " + result);
                    System.out.println(st.toString());
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
            System.out.println(st.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        LargestInHistogram solution = new LargestInHistogram();

        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int val = solution.largestRectangleArea(heights);
        System.out.println(val);
    }

}
