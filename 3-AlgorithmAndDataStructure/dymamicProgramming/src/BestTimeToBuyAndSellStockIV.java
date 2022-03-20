/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToBuyAndSellStockIV
 * Author:   Peter
 * Date:     17/03/2022 12:52
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * History:
 * Version:
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;

        int[][] dp = new int[n][2 * k + 1];
        for (int i = 1; i < 2 * k + 1; i+= 2) {
            dp[0][i] = 0 - prices[0];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j < 2* k + 1; j += 2) {

                // 奇数表示买入状态
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                // 偶数表示卖出状态
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }

        return dp[n-1][2*k];
    }
}
