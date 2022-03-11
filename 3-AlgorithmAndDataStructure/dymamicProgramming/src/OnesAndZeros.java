import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: OnesAndZeros
 * Author:   Peter
 * Date:     10/03/2022 11:21
 * Description:
 * History:
 * Version:
 */
public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; // m controls the number of 0 and n controls the number of 1

        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--){
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] strs = str.split(" ");

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(Arrays.toString(strs));
        System.out.println(strs[1].getClass());
        System.out.println("m: "+ m + " n: " + n);

        OnesAndZeros solution = new OnesAndZeros();
        solution.findMaxForm(strs, m, n);
    }
}