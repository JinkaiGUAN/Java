import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: CombinationSum
 * Author:   Peter
 * Date:     07/02/2022 17:19
 * Description: https://leetcode-cn.com/problems/combination-sum/
 * History:
 * Version:
 */
public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int sum, int startIdx) {
        if (target == sum) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            if (sum > target) {
                break;
            }
            path.add(candidates[i]);
//            target -= candidates[i];
            sum += candidates[i];
            backTracking(candidates, target, sum, i);
//            target += candidates[i];
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
