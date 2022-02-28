/**
 * Copyright (C), Peter GUAN
 * FileName: BackPack
 * Author:   Peter
 * Date:     28/02/2022 11:13
 * Description:
 * History:
 * Version:
 */
public class BackPack {

    public static void main(String[] args) {
        // todo: Use scanner to input the value here.
        int[] weight = {1, 3, 4};
        int[] value  = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);

    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int weightLen = weight.length;
        int valSum = 0;

        int[][] dp = new int[weightLen + 1][bagSize+1];

        // initialization
        for (int i = 0; i <= weightLen; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= weightLen; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        for (int i = 0; i <= weightLen; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
