import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: Permutations
 * Author:   Peter
 * Date:     11/02/2022 09:17
 * Description: https://leetcode-cn.com/problems/permutations/
 * History:
 * Version:
 */
public class Permutations {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        backTracking(nums, used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used) {
        // 此处是因为我门要在同一条路径下记录元素是否使用过， 那么used 数组就需要在参数中传递。 如果只是单纯记录同一层元素使用情况，
        // 只需要在层级结构开始前， 即 for -loop前加入相应的used 数组。 同时对于有些题目 而言， 我们的used数据是全局变量。
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backTracking(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
