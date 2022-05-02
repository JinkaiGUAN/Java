package main.com.peter.java.median;

import java.util.HashMap;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ48LengthOfLongestSubString
 * Author:   Peter
 * Date:     28/04/2022 22:11
 * Description: https://www.nowcoder.com/practice/48d2ff79b8564c40a50fa79f9d5fa9c7?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ48LengthOfLongestSubString {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return int整型
     */
    public int lengthOfLongestSubstring (String s) {
        // write code here
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.get(s.charAt(right)) > 1) {
                // there is element repeated.
                map.put(s.charAt(left), map.get(s.charAt(left++)) - 1);
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
