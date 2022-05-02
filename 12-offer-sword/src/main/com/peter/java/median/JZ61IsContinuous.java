package main.com.peter.java.median;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ61IsContinuous
 * Author:   Peter
 * Date:     02/05/2022 19:22
 * Description: https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265
 * History:
 * Version:
 */
public class JZ61IsContinuous {
    public boolean IsContinuous(int[] numbers) {
        HashSet<Integer> set = new HashSet<Integer>();

        int max = 0, min = 14;
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (val == 0) {
                continue;
            }
            min = Math.min(min, val);
            max = Math.max(max, val);
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
        }

        return max - min < 5;
    }

    public boolean IsContinuous2(int [] numbers) {
        int joker = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                joker++;
            } else if (numbers[i] == numbers[i+1]) {
                return false;
            }
        }
        return numbers[numbers.length - 1] - numbers[joker] < 5;
    }
}
