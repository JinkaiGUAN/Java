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

        return -1;
    }
}
