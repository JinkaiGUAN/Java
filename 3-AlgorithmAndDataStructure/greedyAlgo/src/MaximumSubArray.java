/**
 * Copyright (C), Peter GUAN
 * FileName: MaximumSubarray
 * Author:   Peter
 * Date:     20/02/2022 10:12
 * Description: https://leetcode-cn.com/problems/maximum-subarray/
 * History:
 * Version:
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > res) {
                res = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }

        return res;
    }
}
