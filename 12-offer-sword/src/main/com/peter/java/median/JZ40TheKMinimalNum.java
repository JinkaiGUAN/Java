package main.com.peter.java.median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ40TheKMinimalNum
 * Author:   Peter
 * Date:     25/04/2022 22:25
 * Description: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ40TheKMinimalNum {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //排除特殊情况
        if (k == 0 || input.length == 0) {
            return res;
        }
        //大根堆
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        //构建一个k个大小的堆
        for (int i = 0; i < k; i++) {
            q.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            //较小元素入堆
            if (q.peek() > input[i]) {
                q.poll();
                q.offer(input[i]);
            }
        }
        //堆中元素取出入数组
        for (int i = 0; i < k; i++) {
            res.add(q.poll());
        }
        return res;
    }
}
