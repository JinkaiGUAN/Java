/**
 * Copyright (C), Peter GUAN
 * FileName: JumpGameII
 * Author:   Peter
 * Date:     20/02/2022 11:05
 * Description: https://leetcode-cn.com/problems/jump-game-ii/
 * History:
 * Version:
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length ==0 || nums.length == 1) {
            return 0;
        }

        int count = 0;
        int curCoverRange = 0;
        int maxCoverRange = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCoverRange = Math.max(maxCoverRange, i + nums[i]);
            if (maxCoverRange >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curCoverRange) {
                curCoverRange = maxCoverRange;
                count++;
            }
        }

        return count;
    }
}
