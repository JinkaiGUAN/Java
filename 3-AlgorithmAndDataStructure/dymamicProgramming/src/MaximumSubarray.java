/**
 * Copyright (C), Peter GUAN
 * FileName: MaximumSubarray
 * Author:   Peter
 * Date:     21/03/2022 10:59
 * Description: https://leetcode-cn.com/problems/maximum-subarray/
 * History:
 * Version:
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int m = nums.length;

        int[] dp = new int[m];  // dp[i] 表示包括下标i元素在内的最大和的连续子数组
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < m; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
