/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToBuyAndSellStock
 * Author:   Peter
 * Date:     16/03/2022 11:41
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * History:
 * Version:
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // dp[i][], 表示第i天的买入卖出关系， 第二维度0表示持有股票 1 表示卖出
        if (prices.length == 1) {
            return 0; // 表示不卖也不买
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 第i 天持有股票
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }
}
