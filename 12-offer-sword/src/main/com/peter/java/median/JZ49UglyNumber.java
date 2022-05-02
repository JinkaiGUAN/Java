package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ49UrglyNumber
 * Author:   Peter
 * Date:     29/04/2022 20:25
 * Description: https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=265&tqId=39247&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ49UglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) {
            return index;
        }

        int i2 = 0, i3 = 0, i5 = 0;
        int[] res = new int[index];
        res[0] = 1;

        for (int i = 1; i < index; i++) {
            // get the next urgly number
            res[i] = Math.min(res[i2] * 2, Math.min(res[i3] * 3, res[i5] * 5));

            if (res[i] == res[i2] * 2) {
                i2++;
            }
            if (res[i] == res[i3] * 3) {
                i3++;
            }
            if (res[i] == res[i5] * 5) {
                i5++;
            }
        }

        return res[index - 1];
    }
}
