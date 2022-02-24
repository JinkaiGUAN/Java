import java.util.Arrays;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: QueueReconstructionByHeight
 * Author:   Peter
 * Date:     23/02/2022 23:24
 * Description: https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * History:
 * Version:
 *
 * Explanation
 *
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // 相同身高， 次数小的排在前面
            return b[0] - a[0];  // 按照身高排序， 身高高的放在前面
        });


        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1], p);
        }

        return que.toArray(new int[people.length][]);
    }
}
