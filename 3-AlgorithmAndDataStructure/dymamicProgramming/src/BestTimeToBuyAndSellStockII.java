/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToBuyAndSellStockII
 * Author:   Peter
 * Date:     17/03/2022 10:41
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * History:
 * Version:
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 0 表示第 i天持有股票持有的现金
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 1 表示第i天不持有股票持有的现金
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
