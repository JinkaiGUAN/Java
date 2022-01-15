package src;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Peter
 * @date: 15/01/2022
 * @description: https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public MyQueue() {}

        public void poll(int val) {
            // 弹出元素时， 比较当前要弹出的数值是都等于队列出后的数值， 如果相等则弹出， 同时判断队列当前是否为空
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        public void add(int val) {
            // 添加元素时， 如果要添加的元素大于入口处的元素， 九江入口元素弹出， 保证队列元素单调递减。
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        public int peek() {
            // queue 中是否有元素
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 使用队列作为华东窗口， 每次移动一位， 就移除或者添加 相应元素， 但是我们在队列内部得找到最大值，
        // 但是如何获得最大元素： 单调队列， 即队列中元素是从大到小的, 在队列中， 我们始终只保持两个元素
        if (nums.length == 1) {
            return nums;
        }

        int len = nums.length - k + 1;
        // 存放结果的数组
        int[] res = new int[len];
        int num = 0;

        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }

        res[num++] = myQueue.peek();

        for(int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] array = solution.maxSlidingWindow(nums, 3);
    }
}
