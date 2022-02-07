import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: Combinations
 * Author:   Peter
 * Date:     07/02/2022 08:42
 * Description: https://leetcode-cn.com/problems/combinations/
 * History:
 * Version:
 */
public class Combinations {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int n, int k, int startIdx) {
        // 实行左闭区间
        if (path.size() == k) {
            res.add(new LinkedList<>(path));  // 添加时必须是拷贝一个新数组， 否则数组在回溯之后胃空
            return;
        }

        for (int i = startIdx; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
