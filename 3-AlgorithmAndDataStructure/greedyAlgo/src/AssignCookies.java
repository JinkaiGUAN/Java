import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: AssignCookies
 * Author:   Peter
 * Date:     19/02/2022 09:22
 * Description: https://leetcode-cn.com/problems/assign-cookies/
 * History:
 * Version:
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // g -> children, s -> cookies

        Arrays.sort(g);
        Arrays.sort(s);

        int start = 0, count = 0;

        // 采用该小饼干满足小胃口
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }

        return count;
    }
}
