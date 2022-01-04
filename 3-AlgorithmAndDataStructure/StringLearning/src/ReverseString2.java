/**
 * @author: Peter
 * @date: 04/01/2022
 * @description: https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {

        int n = s.length();
        char[] array = s.toCharArray();

        for (int i = 0;  i < n; i += 2 * k) {
            reverseSubString(array, i, Math.min(i + k, n) - 1);
        }

        return new String(array);

    }

    public void reverseSubString(char[] arr, int left, int right) {
        // 完成前k个字符的反转， 后面保持原装
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }
}
