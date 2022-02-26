/**
 * Copyright (C), Peter GUAN
 * FileName: MinCostClimbingStairs
 * Author:   Peter
 * Date:     26/02/2022 12:14
 * Description: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * History:
 * Version:
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        if (cost.length < 3) {
            return Math.min(cost[0], cost[1]);
        }


        int[] dp = new int[]{0, 0}; // 初始消耗体力位0

        for (int i = 3; i <= cost.length + 1; i++) {
            int minCost = Math.min(dp[1] + cost[i - 2], dp[0] + cost[i - 3]);
            // update dp
            dp[0] = dp[1];
            dp[1] = minCost;
        }

        return dp[1];
    }
}
