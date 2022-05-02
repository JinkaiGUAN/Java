package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ43NumberOf1Between1AndN
 * Author:   Peter
 * Date:     26/04/2022 20:17
 * Description: https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ43NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            String val = Integer.toString(i);
            for (int j = 0; j < val.length(); j++) {
                if (val.charAt(j) == '1') {
                    sum++;
                }
            }
        }

        return sum;
    }
}
