import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: NQueens
 * Author:   Peter
 * Date:     18/02/2022 17:52
 * Description: https://leetcode-cn.com/problems/n-queens/
 * History:
 * Version:
 */
public class NQueens {
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];

        // initialize the chessboard
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        backTracking(n, 0, chessboard);

        return res;
    }

    private void backTracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col, chessboard)) {
                chessboard[row][col] = 'Q';
                backTracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new LinkedList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }

        return list;
    }

    private boolean isValid(int n, int row, int col, char[][] chessboard) {
        // check the same column but various rows
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // check 45 diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // check 135 diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }



}
