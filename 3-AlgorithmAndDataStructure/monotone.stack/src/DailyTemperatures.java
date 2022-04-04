import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: DailyTemperatures
 * Author:   Peter
 * Date:     04/04/2022 21:10
 * Description: https://leetcode-cn.com/problems/daily-temperatures/
 * History:
 * Version:
 * @author Peter
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            // 比较元素， 进行res 更新与元素出栈
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIdx = stack.pop();
                res[preIdx] = i - preIdx;
            }

            // 放入当前下标
            stack.push(i);
        }

        return res;
    }

}
