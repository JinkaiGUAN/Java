package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ11MinimumValueInRotatingArray
 * Author:   Peter
 * Date:     13/04/2022 21:22
 * Description: https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ11MinimumValueInRotatingArray {
    /**
     * The main idea is to find the minimum value, i.e., the start of the original array.
     * Using binary search.
     */
    public int minNumberInRotateArray(int [] array) {

        int left = 0;
        int right = array.length - 1;

        if (right == left) {
            return array[left];
        }

        while (left < right)  {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                // still in the left increasing part
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                // midddle element is in the right increasing part
                right = mid;
            } else {
                right--;
            }
        }

        return array[left];
    }
}
