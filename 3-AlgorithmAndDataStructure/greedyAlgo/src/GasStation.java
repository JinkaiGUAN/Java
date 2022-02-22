/**
 * Copyright (C), Peter GUAN
 * FileName: GasStation
 * Author:   Peter
 * Date:     22/02/2022 21:53
 * Description: https://leetcode-cn.com/problems/gas-station/
 * History:
 * Version:
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // brute force
//        for (int  i = 0; i < gas.length; i++) {
//            int rest = gas[i] - cost[i]; // 表示在当前加油站加完油之后到达下一个加油站还剩余的油量
//            int index = (i + 1) % gas.length;
//
//            while (rest > 0 && index != i) {
//                rest += gas[index] - cost[index];
//                index = (index + 1) % gas.length; // 到达下一个加油站
//            }
//
//            if (rest >= 0 && index == i) {
//                return i;
//            }
//        }
//
//        return -1;
        int curSum = 0;
        int totalSum = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = (i + 1) % gas.length;
                curSum = 0;
            }
        }

        if (totalSum < 0) return -1;
        return start;
    }
}
