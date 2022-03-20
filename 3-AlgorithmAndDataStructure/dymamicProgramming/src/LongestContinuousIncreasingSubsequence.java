import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: LongestContinuousIncreasingSubsequence
 * Author:   Peter
 * Date:     20/03/2022 10:51
 * Description: https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * History:
 * Version:
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        // using dp
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i-1] + 1;
            }
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
