package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ10Fibonacci
 * Author:   Peter
 * Date:     12/04/2022 23:33
 * Description: https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ10Fibonacci {
    /**
     * Using DP
     * dp[i] = dp[i-1]+ dp[i - 2]
     */
    public int Fibonacci(int n) {
        if (n <= 2)  {
            return 1;
        }

        // initialize first two elements
        int x1 = 1;
        int x2 = 1;
        int x = 0;

        for (int i = 3; i <= n; i++) {
            x = x1 + x2;
            // update two elements
            x1 = x2;
            x2 = x;
        }

        return x;
    }
}
