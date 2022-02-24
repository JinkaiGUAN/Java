import java.util.List;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: PartitionLabels
 * Author:   Peter
 * Date:     24/02/2022 23:40
 * Description: https://leetcode-cn.com/problems/partition-labels/
 * History:
 * Version:
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] mapping = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            mapping[c - 'a'] = i;
        }

        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, mapping[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }

        return list;
    }
}
