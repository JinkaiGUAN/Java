/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToBuyAndSellStockII
 * Author:   Peter
 * Date:     20/02/2022 10:34
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * History:
 * Version:
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        // find the profit range
        int totalProfits = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - prices[i-1];
            if (profit > 0) {
                totalProfits += profit;
            }
        }

        return totalProfits;
    }
}
