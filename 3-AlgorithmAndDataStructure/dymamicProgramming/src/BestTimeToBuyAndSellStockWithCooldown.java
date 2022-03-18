/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToBuyAndSellStockWithCooldown
 * Author:   Peter
 * Date:     18/03/2022 11:21
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * History:
 * Version:
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        // 有四个状态， 0 - 今天买入股票状态， 1 - 前两天就卖出股票 过了冷冻期 一直没有处理， 2 - 今天卖出股票， 3 - 冷冻期
        int[][] dp = new int[prices.length][4];
        dp[0][0] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 前面就已经买入， 前面卖出 也就是状态1, 或者前一天是冷冻期
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            // 一直是卖出状态, 冷冻期
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // 今天卖出股票: 前面是买入状态 今天卖出
            dp[i][2] = dp[i - 1][0] + prices[i];
            // 冷冻期: 前一天正好卖出
            dp[i][3] = dp[i - 1][2];
        }

        int n = prices.length;
        return Math.max(dp[n - 1][2], Math.max(dp[n - 1][1], dp[n-1][3]));
    }
}
