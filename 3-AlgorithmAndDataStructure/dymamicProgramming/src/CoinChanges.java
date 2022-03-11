import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: CoinChanges
 * Author:   Peter
 * Date:     11/03/2022 18:11
 * Description: https://leetcode-cn.com/problems/coin-change/
 * History:
 * Version:
 */
public class CoinChanges {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.nextLine();
        String[] strs = numStr.split(" ");
        int[] coins = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            coins[i] = Integer.parseInt(strs[i]);
        }

        int amount = scanner.nextInt();

        CoinChanges solution = new CoinChanges();
        solution.coinChange(coins, amount);
    }
}
