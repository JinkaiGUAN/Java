import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: Subsets
 * Author:   Peter
 * Date:     09/02/2022 14:54
 * Description: https://leetcode-cn.com/problems/subsets/
 * History:
 * Version:
 */
public class Subsets {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return res;
        }
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int [] nums, int startIdx) {
        // 收集子集，要放在终止添加的上面，否则会漏掉自己
        res.add(new ArrayList<>(path));
        if (startIdx >= nums.length) {
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            path.addLast(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
