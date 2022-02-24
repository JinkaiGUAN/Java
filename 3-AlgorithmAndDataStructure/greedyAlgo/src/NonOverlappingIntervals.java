import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: NonOverlappingINtervals
 * Author:   Peter
 * Date:     24/02/2022 22:59
 * Description: https://leetcode-cn.com/problems/non-overlapping-intervals/
 * History:
 * Version:
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
//            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        int res = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length ; i++) {

            if (pre > intervals[i][0]) {
                res++;
                pre = Math.min(pre, intervals[i][1]);
            } else {
                pre = intervals[i][1];
            }

        }

        return res;
    }
}
