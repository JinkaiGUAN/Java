package main.com.peter.java.easy;

import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ29PrintMatrixClockWise
 * Author:   Peter
 * Date:     22/04/2022 22:17
 * Description: https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=265&tqId=39231&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ29PrintMatrixClockWise {
    /**
     * Transpose the matrix
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        while (true) {
            if (count != 0) {
                matrix = rotateMatrix(matrix);
            }

            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }

            count++;
            if (matrix.length == 1) {
                break;
            }
        }

        return list;
    }

    /**
     * Rotate the matrix
     */
    private int[][] rotateMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        // if the column is 1, simply transforming is enough
        if (column == 1) {
            int[][] res = new int[1][row - 1];
            for (int i = 1; i < row; i++) {
                res[0][i - 1] = matrix[i][0];
            }

            return res;
        }

        int[][] res = new int[column][row - 1];
        int res_i = 0;
        int res_j = 0;
        for (int i = column - 1; i >= 0; --i) {
            res_j = 0;
            for (int j = 1; j < row; j++) {
                res[res_i][res_j++] = matrix[j][i];
            }
            res_i++;
        }

        return res;
    }

    /**
     * Brute force
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix2(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 ||(matrix != null && matrix[0] == null)) {
            return list;
        }

        int beginRow = 0;
        int maxRow = matrix.length - 1;
        int beginColumn = 0;
        int maxColumn = matrix[0].length - 1;

        while (maxColumn >= beginColumn && maxRow >= beginRow) {

            // from left to right
            for (int i = beginColumn; i <= maxColumn; i++) {
                list.add(matrix[beginRow][i]);
            }
            // from up to down
            for (int i = beginRow + 1; i<= maxRow; i++) {
                list.add(matrix[i][maxColumn]);
            }
            // form right to left
            if (beginRow != maxRow) {
                for (int i = maxColumn - 1; i >= beginColumn; i--) {
                    list.add(matrix[maxRow][i]);
                }
            }

            // from down to upper
            if (beginColumn != maxColumn) {
                for (int i = maxRow - 1; i > beginRow; i--) {
                    list.add(matrix[i][beginColumn]);
                }
            }

            // update variables
            beginRow++;
            maxRow--;
            beginColumn++;
            maxColumn--;
        }

        return list;
    }
}
