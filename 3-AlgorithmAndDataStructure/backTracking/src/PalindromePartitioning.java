import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: PalindromePartitioning
 * Author:   Peter
 * Date:     08/02/2022 22:30
 * Description: https://leetcode-cn.com/problems/palindrome-partitioning/
 * History:
 * Version:
 */
public class PalindromePartitioning {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);;
        return res;
    }

    public void backTracking(String s, int startIdx) {
        // return condition
        // 如果其实位置大于s的大小， 说明找到一组分割方案
        if (startIdx >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            // 截取的字符串为[startIdx, i]
            if (isPalindrome(s, startIdx, i)) {
                String str = s.substring(startIdx, i + 1);
                path.addLast(str);
            } else {
                continue;
            }

            backTracking(s, i + 1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        // 双指针判断回文, [start, end]
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
