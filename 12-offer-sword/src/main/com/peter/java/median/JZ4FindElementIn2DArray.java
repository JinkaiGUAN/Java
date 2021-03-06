package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ4
 * Author:   Peter
 * Date:     08/04/2022 23:59
 * Description: https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ4FindElementIn2DArray {
    public boolean Find(int target, int [][] array) {
        // 判断是否为空
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) {
            return false;
        }

        int m = array.length;
        int n = array[0].length;
        int pre_j = 0;

        for (int i =0; i < m; i++) {
            for (int j = pre_j; j < n; j ++) {
                if (array[i][j] > target) {
                    // 回退
                    while(j != 0 && array[i][j] > target) {
                        pre_j = --j;
                    }
                    // 存在恰好回腿到target
                    if (array[i][j]  == target) {
                        return true;
                    }
                    break;
                }
                if (array[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * In this question, we can also use binary searching method.
     *
     * Firstly, We assign the right upper element, then compare it with the target value, if it is larger than the target,
     * then we move left. If the element smaller than the target, we move the element pointer down.
     *
     * @param target
     * @param array
     * @return
     */
    public boolean FindByBinarySearch(int target, int [][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) {
            return false;
        }

        int m = array.length;
        int n = array[0].length;

        int r = 0;
        int c = n - 1;

        while (r <= m && c >=  0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }

        return false;

    }
}
