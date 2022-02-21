import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: MaximizeSumOfArrayAfterKNegations
 * Author:   Peter
 * Date:     21/02/2022 10:19
 * Description: https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 * History:
 * Version:
 */
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 1) return k % 2 == 0? nums[0] : -nums[0];

        // sort the array
        Arrays.sort(nums);

        int sum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (i < nums.length - 1 && nums[idx] < 0) {
                nums[idx] = - nums[idx];
                if (nums[idx] >= Math.abs(nums[idx + 1])) {
                    idx++;
                }
                continue;
            }
            nums[idx] = -nums[idx];
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

}
