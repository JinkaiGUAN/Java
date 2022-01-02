import java.util.Map;
import java.util.HashMap;

/**
 * @author: Peter
 * @date: 02/01/2022
 * @description: https://leetcode.com/problems/4sum-ii/
 */
public class FourSum {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 使用hashMap， key 使用前两个数字之和， value 使用对应元素和的个数。 之后对后两个数组进行同样操作， 但是是取出-sum， 并统计总和
        // todo: What if we only input one array? If so, we have to consider the repeated number when collecting the
        //  key-value pair.

        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        int count = 0;

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                table.put(num1 + num2, table.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                count += table.getOrDefault(-(num3 + num4), 0);
            }
        }

        return count;

    }
}
