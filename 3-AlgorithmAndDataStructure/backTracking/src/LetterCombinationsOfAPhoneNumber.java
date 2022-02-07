import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: LetterCombinationsOfAPhoneNumber
 * Author:   Peter
 * Date:     07/02/2022 16:29
 * Description: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * History:
 * Version:
 */
public class LetterCombinationsOfAPhoneNumber {
    List<String> res = new LinkedList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(numString, digits, 0);

        return res;
    }

    public void backTracking(String[] numString, String digits, int num) {
        if (num == digits.length()) {
            res.add(temp.toString());
            return;
        }

        // get the string we have for this digits
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(numString, digits, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
