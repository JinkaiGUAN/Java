package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ47TheMaximumPriceOfGift
 * Author:   Peter
 * Date:     28/04/2022 21:23
 * Description: https://www.nowcoder.com/practice/2237b401eb9347d282310fc1c3adb134?tpId=265&tqId=39288&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ47TheMaximumPriceOfGift {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * dp[i][j]: represents the maximun gifts we can get at point (i, j)
     * dp[i][j] shows the incresing value for i = 0 and j = 0
     * dp[i][j] = Maxt.max(dp[i][j - 1] + W[i][j], dp[i - 1][j] + W[i][j])
     * @param grid int整型二维数组
     * @return int整型
     */
    public int maxValue (int[][] grid) {
        // write code here
        // extreme situation, there is only one point

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        // initialise the dp
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j -1][0] + grid[j][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];

    }
}
