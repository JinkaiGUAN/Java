import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: PermutationsII
 * Author:   Peter
 * Date:     11/02/2022 09:42
 * Description: https://leetcode-cn.com/problems/permutations-ii/
 * History:
 * Version:
 */
public class PermutationsII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, used);
        return res;
    }

    public void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
