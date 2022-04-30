package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ53GetNumberOfK
 * Author:   Peter
 * Date:     30/04/2022 16:40
 * Description: https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ53GetNumberOfK {
    /**
     * Firstly we need to find the position where the first node has shown, then use the poingter to count
     * count it.
     */
    public int GetNumberOfK(int [] array , int k) {

        // get the first occurance index of k
        int index  = binarySearch(array, k);
        if (index == -1) {
            return 0;
        } else {
            int count = countValue(array, index, k);
            return count;
        }
    }

    private int binarySearch(int[] array, int k) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array[0] > k || array[array.length - 1] < k) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                if (mid == 0 || array[mid - 1] != k) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    private int countValue(int[] array, int index, int k) {
        int count = 0;
        for (int i = index; i < array.length; i++) {
            if (array[i] == k) {
                count += 1;
            }
        }

        return count;
    }
}
