package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ15TheNumberOfOneInABinaryNumber
 * Author:   Peter
 * Date:     17/04/2022 21:31
 * Description: https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ15TheNumberOfOneInABinaryNumber {
    public int NumberOf1(int n) {

        int count = 0;

        while ( n != 0) {
            if ( (n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }

        return count;
    }
}
