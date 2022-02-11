import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: IncreasingSubsequences
 * Author:   Peter
 * Date:     11/02/2022 08:52
 * Description: https://leetcode-cn.com/problems/increasing-subsequences/
 * History:
 * Version:
 */
public class IncreasingSubsequences {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int startIdx) {
        if (path.size() >= 2) {
            res.add(new LinkedList<>(path));
        }

        int[] used = new int[201]; // 记录同层是否有相同元素， 该数组下标为元素

        for (int i = startIdx; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || (used[nums[i] + 100] == 1)) {
                // 同一层遇到相同元素
                continue;
            }

            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();

        }
    }
}
