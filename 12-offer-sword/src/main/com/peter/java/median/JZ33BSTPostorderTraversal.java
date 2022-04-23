package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ33BSTPostorderTraversal
 * Author:   Peter
 * Date:     23/04/2022 18:14
 * Description: https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ33BSTPostorderTraversal {
    /**
     * BST's characteristics:
     *  the value of left child is less than that of right child.
     *
     * Postorder traversal: the root is at the end of the array
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }

        return check(sequence, 0, sequence.length - 1);
    }

    private boolean check(int[] array, int left, int right) {
        // return condition
        if (left >= right) {
            // only one node
            return true;
        }

        int rootVal = array[right];
        int j = right - 1;
        // find the right part
        while (j >= 0 && array[j] > rootVal) {
            j--;
        }

        // check the left part of the array
        for (int i = left; i < j; i++) {
            if (array[i] > rootVal) {
                return false;
            }
        }

        return check(array, left, j) && check(array, j + 1, right - 1);
    }
}
