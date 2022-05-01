package main.com.peter.java.median;

import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ57FindNumbersWithSum
 * Author:   Peter
 * Date:     01/05/2022 22:23
 * Description: https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265
 * History:
 * Version:
 */
public class JZ57FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < array.length - 1; i++) {
            int targetIdx = binarySearch(array, i + 1, sum - array[i]);

            if (targetIdx != -1) {
                list.add(array[i]);
                list.add(array[targetIdx]);
                return list;
            }
        }

        return list;
    }

    private int binarySearch(int[] array, int leftIdx, int target) {

        int left = leftIdx;
        int right = array.length - 1;
        if (left == right && target == array[left]) {
            return left;
        }

        if (left >= right) {
            return -1;
        }

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else  {
                return mid;
            }
        }

        return -1;
    }
}
