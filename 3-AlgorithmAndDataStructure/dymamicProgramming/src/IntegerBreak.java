import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: IntegerBreak
 * Author:   Peter
 * Date:     27/02/2022 12:16
 * Description: https://leetcode-cn.com/problems/integer-break/
 * History:
 * Version:
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int res = integerBreak(n);
        System.out.println(res);
    }
}
