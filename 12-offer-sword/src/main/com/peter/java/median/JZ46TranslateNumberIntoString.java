package main.com.peter.java.median;

import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ46TranslateNumberIntoString
 * Author:   Peter
 * Date:     27/04/2022 22:14
 * Description: https://www.nowcoder.com/practice/046a55e6cd274cffb88fc32dba695668?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ46TranslateNumberIntoString {
    /**
     * 解码
     * We would love to use DP to solve this problem.
     * Dp[i]: how many ways we can get from the string [0, i], including the position of i.
     * Dp[i] = Dp[i- 1] + Dp[i - 2], the fist plan is that we cannot combine i - 1 and i,
     * the second plan is that we can combian i and i - 1.
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve(String nums) {
        // write code here
        if (nums == null || nums.length() == 0 || nums.equals("0")) {
            return 0;
        }
        if (nums == "10" || nums == "20") {
            return 1;
        }

        // the number before zero is not one and two
        for (int i = 1; i < nums.length(); i++) {
            if (nums.charAt(i) == '0') {
                if (nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2') {
                    return 0;
                }
            }
        }

        int[] dp = new int[nums.length() + 1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= nums.length(); i++) {
            // 11 - 19, 21-26
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0') ||
                    (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' && nums.charAt(i - 1) < '7')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[nums.length()];
    }
}
