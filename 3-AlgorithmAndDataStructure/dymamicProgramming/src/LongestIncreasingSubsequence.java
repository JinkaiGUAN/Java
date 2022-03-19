import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: LongestIncreasingSubsequence
 * Author:   Peter
 * Date:     19/03/2022 10:58
 * Description: https://leetcode.com/problems/longest-increasing-subsequence/
 * History:
 * Version:
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n]; // represents the longest increasing sequece, including i
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // retrieve  the maximum num
        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }

        return max;
    }
}
