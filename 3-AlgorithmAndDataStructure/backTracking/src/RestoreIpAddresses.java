import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: RestoreIpAddresses
 * Author:   Peter
 * Date:     08/02/2022 23:25
 * Description: https://leetcode-cn.com/problems/restore-ip-addresses/
 * History:
 * Version:
 */
public class RestoreIpAddresses {
    List<String> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0);
        return res;
    }

    public void backTracking(String s, int startIdx, int pointNum) {
        if (pointNum == 3) {
            if (isStrValid(s, startIdx, s.length() - 1)) {
                String lastStr = s.substring(startIdx, s.length());
                path.addLast(lastStr);
                String str = String.join(".", path);
                res.add(str);
                path.removeLast();
            }
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            if (isStrValid(s, startIdx, i)) {
                pointNum++;
                String str = s.substring(startIdx, i + 1);
                path.addLast(str);
                backTracking(s, i + 1, pointNum);
                pointNum--;
                path.removeLast();
            } else {
                break;
            }
        }
    }

    public boolean isStrValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 如果获取数字是大于255， 不合法； 数字开头有0，但是整体大于0， 不合法； 如果获取数字不是在0-9区间内， 不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }

            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "25525511135";
        RestoreIpAddresses solution = new RestoreIpAddresses();
        solution.restoreIpAddresses(str);
        System.out.println(solution.res.toString());
    }
}
