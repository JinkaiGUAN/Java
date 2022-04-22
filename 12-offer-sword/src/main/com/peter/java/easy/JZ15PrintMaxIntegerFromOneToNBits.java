package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ15
 * Author:   Peter
 * Date:     18/04/2022 21:56
 * Description: https://www.nowcoder.com/practice/4436c93e568c48f6b28ff436173b997f?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 * @author Peter
 */
public class JZ15PrintMaxIntegerFromOneToNBits {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 最大位数
     * @return int整型一维数组
     */
    public int[] printNumbers (int n) {
        // write code here
        int maxVal = 1;
        for (int i = 1; i <= n; i++) {
            maxVal *= 10;
        }
        maxVal--;

        int[] array = new int[maxVal];
        for (int i = 1; i <= maxVal; i++) {
            array[i - 1] = i;
        }

        return array;
    }
}
