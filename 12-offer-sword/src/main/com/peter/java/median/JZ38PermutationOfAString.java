package main.com.peter.java.median;

import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ38PermutationOfAString
 * Author:   Peter
 * Date:     25/04/2022 21:32
 * Description: https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ38PermutationOfAString {
    private ArrayList<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] used;

    /**
     * Find the pertubation of a string.
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }

        used = new boolean[str.length()];

        backTracking(str, used);

        return res;
    }

    private void backTracking(String str, boolean[] used) {
        if (path.length() == str.length()) {
            if (!res.contains(path.toString())) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i] != true) {
                used[i] = true;
                path.append(str.charAt(i));
                backTracking(str, used);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
