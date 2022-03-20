/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToSellStockWithTractionFee
 * Author:   Peter
 * Date:     19/03/2022 10:32
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * History:
 * Version:
 */
public class BestTimeToSellStockWithTractionFee {

    /**
     * Actually, this problem can be solved by greedy algorithm.
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        // In this part, dp is used. 0 represents the the maximum money we can get if we hold the stock; 1 represents the maximum money we can get if we sell the money
        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);

        if (prices.length == 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0] - fee;
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
