import java.util.Arrays;
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

    public void backTracking(int[] candidates, int target, int startIdx) {
        // todo: figure out why this function does not work? - Before we use this function, we must sort the
        //  candidates so that we can repeatedly use the minimal value.
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            target -= candidates[i];
            backTracking(candidates, target, i);
            target += candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 7, 6, 3, 5, 1};
        int target = 9;
//        Arrays.sort(candidates);
        CombinationSum solution = new CombinationSum();
        solution.backTracking(candidates, target, 0);
//        solution.combinationSum(candidates, target);
        System.out.println(solution.res.size());
        System.out.println(solution.res.toString());
    }
}
