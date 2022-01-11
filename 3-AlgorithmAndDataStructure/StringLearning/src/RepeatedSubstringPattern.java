/**
 * @author: Peter
 * @date: 11/01/2022
 * @description: https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();

        int[] next = new int[len];
        getNext(next, s);

        if (next[len - 1] != 0 && len % (len - (next[len - 1])) == 0) {
            return true;
        }

        return false;
    }

    public void getNext(int[] next, String needle) {
        int j = 0;
        next[0] = j;

        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
