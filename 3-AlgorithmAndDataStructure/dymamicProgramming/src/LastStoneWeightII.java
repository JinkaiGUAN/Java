import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: LastStoneWeightII
 * Author:   Peter
 * Date:     06/03/2022 11:38
 * Description: https://leetcode-cn.com/problems/last-stone-weight-ii/
 * History:
 * Version:
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] - dp[target];

    }


    public static void main(String[] args) {
        // read the io stream
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] strArr = s.split(" ");
        int[] stones = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            stones[i] = Integer.parseInt(strArr[i]);
        }

        // solve the problem
        LastStoneWeightII solution = new LastStoneWeightII();
        int weight = solution.lastStoneWeightII(stones);
        System.out.println(weight);

    }
}
