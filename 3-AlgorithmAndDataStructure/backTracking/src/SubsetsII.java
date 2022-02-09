import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: SubsetsII
 * Author:   Peter
 * Date:     09/02/2022 15:28
 * Description: https://leetcode-cn.com/problems/subsets-ii/
 * History:
 * Version:
 */
public class SubsetsII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Boolean[] used;

    public  List<List<Integer>> subsetWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            res.add(new LinkedList<>(path));
            return res;
        }

        Arrays.sort(nums);
        used = new Boolean[nums.length];
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int startIdx) {
        res.add(new LinkedList<>(path));
        if (startIdx >= nums.length) {
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
                // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            backTracking(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
