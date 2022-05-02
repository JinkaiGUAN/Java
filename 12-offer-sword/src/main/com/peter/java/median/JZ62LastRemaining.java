package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ62LastRemaining
 * Author:   Peter
 * Date:     02/05/2022 20:16
 * Description: https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265
 * History:
 * Version:
 */
public class JZ62LastRemaining {

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }

        return function(n, m);
    }


    private int function(int n, int m) {
        if (n == 1) {
            return 0;
        }

        int x = function(n - 1, m);

        return (m + x) % n;
    }
}
