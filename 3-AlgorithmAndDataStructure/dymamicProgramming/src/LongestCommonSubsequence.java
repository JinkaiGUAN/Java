/**
 * Copyright (C), Peter GUAN
 * FileName: LongestCommonSubsequence
 * Author:   Peter
 * Date:     20/03/2022 11:35
 * Description: https://leetcode-cn.com/problems/longest-common-subsequence/
 * History:
 * Version:
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 ==char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
