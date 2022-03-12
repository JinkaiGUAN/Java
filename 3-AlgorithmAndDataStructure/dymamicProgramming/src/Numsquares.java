/**
 * Copyright (C), Peter GUAN
 * FileName: Numsquares
 * Author:   Peter
 * Date:     12/03/2022 23:02
 * Description:
 * History:
 * Version:
 */
public class Numsquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++){
            dp[i] = max;
        }

        for (int i = 1; i*i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i * i) {
                    dp[j] = Math.min(dp[j], dp[j - i*i] +1 );
                }
            }
        }

        return dp[n];
    }
}
