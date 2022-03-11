import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: CombinationSumIV
 * Author:   Peter
 * Date:     11/03/2022 17:13
 * Description: https://leetcode-cn.com/problems/combination-sum-iv/
 * History:
 * Version:
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1]; // it represents how many kinds of methods we can get givne the capacity of j
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.nextLine();
        String[] strs = numStr.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int target = scanner.nextInt();

        CombinationSumIV solution = new CombinationSumIV();
        solution.combinationSum4(nums, target);
    }
}
