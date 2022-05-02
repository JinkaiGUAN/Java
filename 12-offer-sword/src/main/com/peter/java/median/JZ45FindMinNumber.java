package main.com.peter.java.median;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ45FindMinNumber
 * Author:   Peter
 * Date:     27/04/2022 21:16
 * Description: https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ45FindMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            res.append(nums[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String.parseInt("23");
    }
}
