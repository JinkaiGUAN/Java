/**
 * Copyright (C), Peter GUAN
 * FileName: BestTimeToBuyAndSellStockWithTransactionFee
 * Author:   Peter
 * Date:     25/02/2022 11:28
 * Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * History:
 * Version:
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];

            if (prices[i] >= minPrice && prices[i] <= minPrice + fee) continue;

            if (prices[i] > minPrice + fee) {
                res += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee; // 为了放在在后续实际卖出时间时重复减去手续费
            }
        }

        return res;
    }
}
