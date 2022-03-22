/**
 * Copyright (C), Peter GUAN
 * FileName: IsSubsequence
 * Author:   Peter
 * Date:     21/03/2022 11:16
 * Description: https://leetcode-cn.com/problems/is-subsequence/
 * History:
 * Version:
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i < length1 + 1; i++) {
            char char1 = s.charAt(i - 1);
            for (int j = 1; j < length2 + 1; j++) {
                char char2 = t.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        if (dp[length1][length2] == length1) {
            return true;
        } else {
            return false;
        }
    }
}
