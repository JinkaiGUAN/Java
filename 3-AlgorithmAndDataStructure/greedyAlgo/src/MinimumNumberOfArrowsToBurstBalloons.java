import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: MinimumNumberOfArrowsToBurstBalloons
 * Author:   Peter
 * Date:     24/02/2022 22:08
 * Description: https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * History:
 * Version:
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        // points 是水平方向上气球直径的开始和终止坐标

//        Arrays.sort(points, (a, b) -> {return a[0] - b[0];});
        // 不能简单是用int相减来判断大小， 因为会出现数值超过32 位情况

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int res = 1;
        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > points[i-1][1]) {
                res++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }
        }

        return res;

    }
}
