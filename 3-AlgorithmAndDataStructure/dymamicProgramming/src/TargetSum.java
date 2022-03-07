import java.lang.annotation.Target;
import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: TargetSum
 * Author:   Peter
 * Date:     07/03/2022 11:47
 * Description: https://leetcode-cn.com/problems/target-sum/
 * History:
 * Version:
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;

        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagSize];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArr = scanner.nextLine().split(" ");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }

        int target = scanner.nextInt();

        TargetSum solution = new TargetSum();
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}
