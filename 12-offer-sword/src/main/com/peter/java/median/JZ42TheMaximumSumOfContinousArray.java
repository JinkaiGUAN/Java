package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ42TheMaximumSumOfContinousArray
 * Author:   Peter
 * Date:     26/04/2022 19:49
 * Description: https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=265&tqId=39244&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ42TheMaximumSumOfContinousArray {
    /**
     * Dp[i]: represent the maximun summation up to this element.
     * The array can be gotten from, we take the element, we did not take the element
     * Dp[i] = Math.max(array[i], Dp[i - 1] + array[i])
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];

        for(int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }
}
