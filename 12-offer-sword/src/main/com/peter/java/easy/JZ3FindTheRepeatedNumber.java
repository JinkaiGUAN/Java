package main.com.peter.java.easy;

import java.util.HashSet;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ3FindTheRepeatedNumber
 * Author:   Peter
 * Date:     24/04/2022 17:48
 * Description: https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=265&tags=&title=&difficulty
 * =&judgeStatus=&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ3FindTheRepeatedNumber {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        // write code here
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) {
                return numbers[i];
            }
            set.add(numbers[i]);
        }

        return -1;
    }
}
