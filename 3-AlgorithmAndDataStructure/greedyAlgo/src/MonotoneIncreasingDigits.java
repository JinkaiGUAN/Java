/**
 * Copyright (C), Peter GUAN
 * FileName: MonotoneIncreasingDigits
 * Author:   Peter
 * Date:     25/02/2022 10:54
 * Description: https://leetcode-cn.com/problems/monotone-increasing-digits/
 * History:
 * Version:
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String[] strings = (n + "").split("");
        int start = strings.length; // 记录从什么地方开始后面的数字都变为9
        for (int i = strings.length - 1; i >= 1; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i-1])) {
                strings[i-1] = (Integer.parseInt(strings[i-1]) - 1) + "";
                start = i;  // 标记变为9的位置
            }
        }

        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }

        return Integer.parseInt(String.join("", strings));

    }
}
