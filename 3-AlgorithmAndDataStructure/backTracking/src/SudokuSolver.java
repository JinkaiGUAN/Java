/**
 * Copyright (C), Peter GUAN
 * FileName: SudokuSolver
 * Author:   Peter
 * Date:     18/02/2022 11:31
 * Description: https://leetcode-cn.com/problems/sudoku-solver/
 * History:
 * Version:
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            // 遍历行
            for (int j = 0; j < 9; j++) {
                // iterate the value in col
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (solveSudokuHelper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }

                // all numbers have been tested, and there is no suitable one, so return false
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int row, int col, char val, char[][] chessboard) {
        // same row
        for (int i = 0; i < 9; i++) {
            if (chessboard[row][i] == val) {
                return false;
            }
        }

        // same col
        for (int i = 0; i < 9; i++) {
            if (chessboard[i][col] == val) {
                return false;
            }
        }

        // In the 3 by 3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (chessboard[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
