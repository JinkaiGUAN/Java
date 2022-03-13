/**
 * Copyright (C), Peter GUAN
 * FileName: HouseRobbingII
 * Author:   Peter
 * Date:     13/03/2022 23:40
 * Description: https://leetcode-cn.com/problems/house-robber-ii/
 * History:
 * Version:
 */
public class HouseRobbingII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int moneyStart = robHelper(nums, 0, nums.length - 2);
        int moneyEnd = robHelper(nums, 1, nums.length - 1);

        return Math.max(moneyStart, moneyEnd);
    }

    public  int robHelper(int[] nums, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return nums[startIdx];
        }

        int[] dp = new int[nums.length];
        dp[startIdx] = nums[startIdx];
        dp[startIdx + 1] = Math.max(nums[startIdx], nums[startIdx + 1]);

        for (int i = startIdx + 2; i <= endIdx; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[endIdx];
    }

}
