/**
 * @author: Peter
 * @date: 07/01/2022
 * @description: https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class LeftRotateString {
    public String reverseLeftWords(String s, int n) {
        // s.substring(n, s.length()) + s.substring(0, n);

        StringBuilder sb = new StringBuilder();

        for (int i = n;  i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }

        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        // 先局部反转被划分的两个部分， 然后总体反转

        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, len - 1);

        return sb.reverse().toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }

    }
}
