import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: CoinChange2
 * Author:   Peter
 * Date:     10/03/2022 12:09
 * Description:
 * History:
 * Version:
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // 在没有放入任何coin的时候 此处累计只有一个方法

        // 本题求解组合数， 因此外循环为coin 内循环为背包重量
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String amountStr = scanner.nextLine();
        int amount = Integer.parseInt(amountStr);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int[] coins = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            try {
                coins[i] = Integer.parseInt(strs[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        System.out.println(amount);
        System.out.println(Arrays.toString(coins));

        CoinChange2 solution = new CoinChange2();
        System.out.println(solution.change(amount, coins));
    }
}
