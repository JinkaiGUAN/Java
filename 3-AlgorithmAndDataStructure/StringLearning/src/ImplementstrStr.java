/**
 * @author: Peter
 * @date: 07/01/2022
 * @description: https://leetcode.com/problems/implement-strstr/
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;

        int n = haystack.length(), m = needle.length();

        // todo: filter repeated words
        for (int i = 0; i +  m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }

    public int strStrKMP(String haystack, String needle) {
        // Here are are going to use KMP to implement this function, which can increase the working efficiency.
        // KMP -> 字符串匹配问题

        if (needle.length() == 0) return 0;

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }

        return -1;
    }

    public void getNext(int[] next, String s) {
        // 获取next数组， next数组：下标i之前（包括i）的字符串中， 有多大长度的相同前缀后缀
        int j = -1;
        next[0] = j;
        for(int i = 0; i < s.length(); i++){
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }

            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

}
