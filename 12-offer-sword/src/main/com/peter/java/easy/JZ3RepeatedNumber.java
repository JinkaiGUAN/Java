package main.com.peter.java.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ3RepeatedNumber
 * Author:   Peter
 * Date:     08/04/2022 23:30
 * Description: https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ3RepeatedNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        // write code here
        Set<Integer> set = new HashSet<>();
        for (int number :  numbers) {
            if (set.contains(number)) {
                return number;
            }
            set.add(number);
        }

        return -1;
    }
}
