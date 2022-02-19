/**
 * Copyright (C), Peter GUAN
 * FileName: WiggleSubsequence
 * Author:   Peter
 * Date:     19/02/2022 09:33
 * Description: https://leetcode-cn.com/problems/wiggle-subsequence/
 * History:
 * Version:
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {

        int count = 1, preDiff = 0, curDiff = 0;

        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if (curDiff > 0 && preDiff <= 0 || preDiff >= 0 && curDiff < 0) {
                count++;
                preDiff = curDiff;
            }
        }

        return count;
    }
}
