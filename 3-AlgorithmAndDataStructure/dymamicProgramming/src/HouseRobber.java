import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: HouseRobber
 * Author:   Peter
 * Date:     13/03/2022 22:43
 * Description: https://leetcode-cn.com/problems/house-robber/
 * History:
 * Version:
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new dp[nums.length]; // dp[i] 表示下标i以内 (包括i) 的房屋内， 最多可以偷窃的金额
        // 如果rob第i间房， 那么dp[i] = dp[i-2] + nums[i], 反之dp[i] = dp[i-1], 但不一定要rob第i-1间房间

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numStrs = scanner.nextLine().split(" ");
        int[] nums = new int[numStrs.length];
        for(int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }

        HouseRobber solution = new HouseRobber();
        System.out.println(solution.rob(nums));
    }
}
