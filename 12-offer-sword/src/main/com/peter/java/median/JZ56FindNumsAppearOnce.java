package main.com.peter.java.median;

import java.util.HashMap;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ56FindNumsAppearOnce
 * Author:   Peter
 * Date:     01/05/2022 22:03
 * Description: https://www.nowcoder.com/practice/389fc1c3d3be4479a154f63f495abff8?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265
 * History:
 * Version:
 */
public class JZ56FindNumsAppearOnce {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            if (map.get(array[i]) > 1) {
                map.remove(array[i]);
            }
        }

        int[] res = new int[2];
        int i = 0;
        for (Integer num : map.keySet()){
            res[i++] = num;
        }

        return res;
    }
}
