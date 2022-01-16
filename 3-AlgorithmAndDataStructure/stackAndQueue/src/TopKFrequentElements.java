package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.PriorityQueue;

/**
 * @author: Peter
 * @date: 16/01/2022
 * @description: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry: entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i = k - 1; i >= 0; i --) {
            result[i] = queue.poll().getKey();
        }

        return result;

    }
}
