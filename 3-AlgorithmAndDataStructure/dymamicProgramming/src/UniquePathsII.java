/**
 * Copyright (C), Peter GUAN
 * FileName: UniquePathsII
 * Author:   Peter
 * Date:     27/02/2022 11:56
 * Description: https://leetcode-cn.com/problems/unique-paths-ii/
 * History:
 * Version:
 */
public class UniquePathsII {
    public int uniquePathsWIthObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || (obstacleGrid.length == 1 || obstacleGrid[0].length == 0)) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                // 碰到障碍物
                dp[i][0] = 0;
                break; // 注意这里利用到java数组初始化位0的性质
            }
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (obstacleGrid[i][j] != 1) {
                    // 没有障碍物
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                } else {
                    dp[i][j] = 0;
                }

            }
        }

        return dp[m - 1][n - 1];
    }
}
