/**
 * Copyright (C), Peter GUAN
 * FileName: MaximumLengthOfRepeatedSubarray
 * Author:   Peter
 * Date:     20/03/2022 11:20
 * Description: https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * History:
 * Version:
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }
        }

        return res;
    }
}
