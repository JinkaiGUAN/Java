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
        for(int i = 1; i < s.length(); i++){
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }

            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

    public int[] getNext(String needle) {
        // q前后缀表到底有什么用
        // next[i] 表示i（包括i）之前最长相等的前后缀长度， 即为j
        int[] next = new int[needle.length()];

        // 1. 初始化: 定义两个指针i和j， j指向前缀起始位置（不包括）， i指向后缀起始位置（包括 ）
        int j = -1;
        next[0] = j;

        for (int i = 1; i < needle.length(); i++) {
            //2. 处理前后缀不相同的情况
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                // 前后缀不相同: 遇见冲突， 看next数组的前一位
                j = next[j]; // 向前回退
            }

            //3. 处理前后缀相同的情况
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                // 找到相同的前后缀
                j++;
            }
            next[i] = j;
        }

        return new int[]{};
    }

    public void getNextSelfMade(int[] next, String needle) {
        // i ： 后缀末尾， j： 前缀末尾, (i (包括i)最长相等前后缀的长度)
        // 1. 初始化
        int j = 0;
        next[0] = j;

        for (int i = 1; i < needle.length(); i++) {

            // 2. 前后缀不相同的情况
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            // 3. 前后缀相同的情况
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 4. update next array
            next[i] = j;
        }
    }
}
