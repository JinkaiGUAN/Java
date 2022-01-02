import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * @author: Peter
 * @date: 02/01/2022
 * @description: https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public int[] toSum(int[] nums, int target) {
        // 首先我们线性遍历所有元素， 然后用target-num得到要在剩下列表中寻找的元素， 使用二分查找将寻找降到O（logn），
        // 原因是题目中只有一个pair可以满足要求
        //todo: Here the problem is that we change the original array, which change the index
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int newTarget = target - nums[i];
            int newIdx = binarySearch(nums, i + 1, nums.length, newTarget);
            if (newIdx != -1) {
                return new int[] {i, newIdx};
            }
        }

        return new int[]{-1, -1};
    }


    public int binarySearch(int[] array, int left, int right, int target) {
        // array 是原始数组， left， right分表当前子数组的起始和终止下标

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int[] twoSum2(int[] nums, int target) {
        // In in part, we are going to use hash map to settle the problem.
        // The key is the num, the value is the index
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i])) {
                return new int[] {i, table.get(target-nums[i])};
            }

            table.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4};
        int target = 6;
        TwoSum solution = new TwoSum();

        int[] ans = solution.twoSum2(array, target);

        System.out.println(Arrays.toString(ans));
    }

}
