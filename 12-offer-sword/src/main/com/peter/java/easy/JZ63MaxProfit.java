package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ63MaxProfit
 * Author:   Peter
 * Date:     03/05/2022 21:33
 * Description: https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=265&tqId=39287&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265&difficulty=undefined
 * &judgeStatus=undefined&tags=&title=
 * History:
 * Version:
 */
public class JZ63MaxProfit {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            minPrice = Math.min(prices[i], minPrice);
        }

        return maxProfit;
    }
}
