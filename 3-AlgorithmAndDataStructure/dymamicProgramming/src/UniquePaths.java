/**
 * Copyright (C), Peter GUAN
 * FileName: UniquePaths
 * Author:   Peter
 * Date:     27/02/2022 11:26
 * Description: https://leetcode-cn.com/problems/unique-paths/
 * History:
 * Version:
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {

        if (m <= 1 || n <= 1) return 1;

        int[][] dp= new int[m][n];
        // initialize the start points
        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 初始化行
                if (i ==0 && j != 0) {
                    dp[i][j] = 1;
                }

                // 初始化列
                if (j == 0 && i != 0) {
                    dp[i][j] = 1;
                }

                //update other grid
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];

    }
}
