import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: PartitionEqualSubsetSum
 * Author:   Peter
 * Date:     01/03/2022 11:41
 * Description: https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * History:
 * Version:
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int[] nums = parseLineToIntArr(s);

        System.out.println(canPartition(nums));
    }

    public static int[] parseLineToIntArr(String s) {
        if (s.isEmpty()) return null;

        String[] strArr = s.split(" ");
        int strLen = strArr.length;

        int[] intArr = new int[strLen];
        for (int i = 0; i < strLen; i++) {
            try {
                intArr[i] = Integer.parseInt(strArr[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return intArr;
    }

    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;
        int target = sum / 2;

        // 使用dp table来获取子集, 表示在i承受哦范围内所达到的最大重量
        int[] dp = new int[target + 1];
        // initialize the dp to zero

        for (int i = 1; i <= nums.length; i++) {
            if (dp[target] == target) {
                return true;
            }
            for (int j = target; j >= nums[i - 1]; j--) {
                // j = 0 时， 不能装任何元素， 因此可以不用遍历
                dp[j] = Math.max(dp[j], dp[j - nums[i - 1]] + nums[i - 1]);

            }
        }

        return false;
    }
}
