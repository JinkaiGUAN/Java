package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ16TheExponentOfBase
 * Author:   Peter
 * Date:     18/04/2022 21:27
 * Description: https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=265&tqId=39220&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 * @author Peter
 */
public class JZ16TheExponentOfBase {
    public double Power(double base, int exponent) {
        // brute force 1, using iteration
        //if (exponent < 0.0) {
        //    return 1.0 / exponential(base, -exponent);
        //}
        //
        //return exponential(base, exponent);

        // brute force 2, using binary searching
        return exponent < 0.0 ? 1.0 / exponentialRecursion(base, -exponent) : exponentialRecursion(base, exponent);
    }

    private double exponential(double base, int exponent) {
        if (exponent == 0.0) {
            return 1.0;
        }

        double res = base;

        for (int i = 1; i < exponent; i++) {
            res *= exponent;
        }

        return res;
    }

    private double exponentialRecursion(double base, int exponent) {
        // return condition
        if (exponent == 0) {
            return 1.0;
        }

        double res;
        int newExponent = exponent / 2;

        if (exponent % 2 == 1) {
            res = exponentialRecursion(base, newExponent) * exponentialRecursion(base, newExponent) * base;
        } else {
            // exponent % 2 == 0
            res = exponentialRecursion(base, newExponent) * exponentialRecursion(base, newExponent);
        }

        return res;
    }
}
