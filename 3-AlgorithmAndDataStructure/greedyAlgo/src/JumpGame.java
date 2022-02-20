/**
 * Copyright (C), Peter GUAN
 * FileName: JumpGame
 * Author:   Peter
 * Date:     20/02/2022 10:47
 * Description: https://leetcode-cn.com/problems/jump-game/
 * History:
 * Version:
 */
public class JumpGame {
    public boolean canJump(int[] nums){
        if (nums.length == 1) {
            return true;
        }

        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length -1) {
                return true;
            }
        }

        return false;
    }
}
