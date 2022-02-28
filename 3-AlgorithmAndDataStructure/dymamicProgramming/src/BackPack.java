import java.util.Scanner;

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
        int[] weight = null; // {1, 3, 4};
        int[] value  = null; // {15, 20, 30};
        int bagSize = 0; // 4;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input weight list: ");
        String lineWeight = scanner.nextLine();
        weight = parseLineToIntArr(lineWeight);

        System.out.println("Please input Value list: ");
        String lineValue = scanner.nextLine();
        value = parseLineToIntArr(lineValue);

        System.out.println("Please input bag size: ");
        bagSize = scanner.nextInt();

        testWeightBagProblem(weight, value, bagSize);

    }

    public static int[] parseLineToIntArr(String s) {
        if (s.isEmpty()) {
            return new int[]{};
        }
        String[] strArr = s.split(" ");
        int strArrLen = strArr.length;

        int[] intArr = new int[strArrLen];
        for (int i = 0; i < strArrLen; i++) {
            try {
                intArr[i] = Integer.parseInt(strArr[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return intArr;
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int weightLen = weight.length;
        int valSum = 0;

        int[][] dp = new int[weightLen + 1][bagSize+1];

        // initialization, 将没有物体的时候重量都置为0
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
