package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ14CutString
 * Author:   Peter
 * Date:     17/04/2022 21:01
 * Description: https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ14CutString {

    private int[] solvedList;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * Here, we are going to use recursion to solve the problem.
     *
     * @param n int整型
     * @return int整型
     */
    public int cutRope (int n) {
        // write code here
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        // record the value that has been calculated before.
        this.solvedList = new int[n + 1];
        this.solvedList[0] = -1;
        this.solvedList[1] = -1;
        this.solvedList[2] = 1;
        this.solvedList[3] = 2;

        return backTracking(n);
    }

    /**
     * @param n: represents the length of a string
     */
    private int backTracking(int n) {
        // return condition
        if (n <= 4) {
            return n;
        }

        // if the value has been recorded, return it.
        int temp = this.solvedList[n];
        if (temp != -1 && temp != 0) {
            return temp;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, i * backTracking(n - i));
        }

        // assign the value
        this.solvedList[n] = res;

        return res;

    }
}
