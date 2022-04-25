package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ39TheOccuringTimesLargerThanHalf
 * Author:   Peter
 * Date:     25/04/2022 22:05
 * Description: https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ39TheOccuringTimesLargerThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int n = array.length;
        int x = array[0];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                x = array[i];
                cnt = 1;
            } else {
                if (array[i] != x) {
                    --cnt;
                } else {
                    ++cnt;
                }
            }
        }

        return x;
    }
}
