import java.util.LinkedList;
import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: MergeIntervals
 * Author:   Peter
 * Date:     25/02/2022 10:33
 * Description: https://leetcode-cn.com/problems/merge-intervals/
 * History:
 * Version:
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i - 1][1]) {
                // no overlapping
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);
    }

}
