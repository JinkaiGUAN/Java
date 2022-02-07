import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: CombinationSumIII
 * Author:   Peter
 * Date:     07/02/2022 15:52
 * Description: https://leetcode-cn.com/problems/combination-sum-iii/
 * History:
 * Version:
 */
public class CombinationSumIII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int N = 9;

    public List<List<Integer>> combinationSUm3(int k, int n) {
        backTracking(k, n, 1);
        return res;
    }

    public void backTracking(int k, int n, int startIdx) {
        if (path.size() == k) {
            int sum = 0;
            for (Integer integer : path) {
                sum += integer;
            }
            if (sum == n) {
                res.add(new LinkedList<>(path));
            }
            return;
        }

        for (int i = startIdx; i <= N - (k - path.size()) + 1; i ++) {
            path.add(i);
            backTracking(k, n, i + 1);
            path.removeLast();
        }
    }
}
