/**
 * @author: Peter
 * @date: 07/01/2022
 * @description: https://leetcode.com/problems/implement-strstr/
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;

        // todo: filter repeated words
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int left = 0;
                while (left < needle.length() && (i + left) < haystack.length() && haystack.charAt(i + left) == needle.charAt(left))
                    left++;
                    if (left == needle.length()) return i;
            }
        }

        return -1;
    }
}
