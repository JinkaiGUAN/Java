/**
 * @author: Peter
 * @date: 04/01/2022
 * @description: https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char tem = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tem;
        }


    }
}
