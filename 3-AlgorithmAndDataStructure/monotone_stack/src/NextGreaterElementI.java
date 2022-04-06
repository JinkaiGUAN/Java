import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: NextGreaterElementI
 * Author:   Peter
 * Date:     04/04/2022 22:06
 * Description: https://leetcode-cn.com/problems/next-greater-element-i/
 * History:
 * Version:
 * @author Peter
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        // 利用map来对nums1 进行映射， 判断nums1【i] 是否与nums【j】相等
        Map<Integer, Integer> umap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            umap.put(nums1[i], i);
        }

        // 构建单调增stack
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                if (umap.containsKey(nums2[stack.peek()])) {
                    Integer idx = umap.get(nums2[stack.peek()]);
                    res[idx] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);

        }

        return res;
    }
}
