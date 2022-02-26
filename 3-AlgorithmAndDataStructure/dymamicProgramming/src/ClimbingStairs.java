/**
 * Copyright (C), Peter GUAN
 * FileName: ClimbingStairs
 * Author:   Peter
 * Date:     26/02/2022 11:45
 * Description: https://leetcode-cn.com/problems/climbing-stairs/
 * History:
 * Version:
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // initialize the dp, dp(1) = 1, dp(2) = 2
        int[] dp = new int[]{1, 2};

        for (int i = 3;  i <= n; i++) {
            int sum = dp[0] + dp[1];
            // update value
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return dp[1];
    }
}
