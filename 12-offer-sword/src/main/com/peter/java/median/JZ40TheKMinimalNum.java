package main.com.peter.java.median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ40TheKMinimalNum
 * Author:   Peter
 * Date:     25/04/2022 22:25
 * Description: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ40TheKMinimalNum {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
    }

    private void sortReverse(int[] array) {
        // method 1
        //Arrays.sort(new int[][]{array}, Collections.reverseOrder());
        //
        //// method 2
        //Arrays.sort(array, (o1, o2) -> {return o2 - o1;});
    }
}
