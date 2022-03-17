/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToBuyAndSellStockIII
 * Author:   Peter
 * Date:     17/03/2022 11:04
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * History:
 * Version:
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int days = prices.length;

        int[][] dp = new int[days][5];
        // 0 表示没有操作， 1 表示第一次买入， 2 表示第一次卖出， 3 表示第二次买入， 4 表示第二次卖出
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][3] = - prices[0]; //当天卖出 又买入


        for (int i = 1; i < days; i++) {
            dp[i][0] = dp[i - 1][0];
            // 持有前一天的股票， 当天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 前一天就已经卖出， 或者当天卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 持有前一天的股票， 当天买入
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            // 前一天就已经卖出， 或者当天卖出
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[days - 1][4];
    }
}
