package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ66Multiply
 * Author:   Peter
 * Date:     04/05/2022 19:33
 * Description: https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265
 * History:
 * Version:
 */
public class JZ66Multiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;

        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] *= temp;
            temp *= A[i];
        }

        return B;
    }
}
