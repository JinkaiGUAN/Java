package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ12ThePathInMatrix
 * Author:   Peter
 * Date:     13/04/2022 22:20
 * Description: https://www.nowcoder.com/practice/2a49359695a544b8939c77358d29b7e6?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ12ThePathInMatrix {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        char[] words = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0;  j < matrix[0].length; j++)  {
                if (dfs(matrix, words, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * For this question, we can treat it as a four-child tree.
     */
    private boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        // return condition
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[index]) {
            return false;
        }

        if (index == words.length - 1) {
            return true;
        }

        char temp = board[i][j];
        // modify the value of current board
        board[i][j] = '.';
        boolean res = dfs(board, words, i + 1, j, index + 1)
                || dfs(board, words, i - 1, j, index + 1)
                || dfs(board, words, i, j + 1, index + 1)
                || dfs(board, words, i, j - 1, index + 1);

        // change the value back
        board[i][j] = temp;

        return res;
    }
}
