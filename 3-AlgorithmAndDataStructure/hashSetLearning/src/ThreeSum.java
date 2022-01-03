import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author: Peter
 * @date: 02/01/2022
 * @description: https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSUm(int[] nums) {
        // 排序数组， 之后开始枚举， 枚举是要注意避免重复数据
        // 但是我们发现使用hashMap 会很难去重， 尤其是遇到【0， 0， 0】此类的数据， 荣日引起超时
        // 可以使用双指针，

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 对原数据进行排序， 注意下标会变化， 若是返回下标， 则不适合

        for (int i = 0; i < nums.length; i++) {
            // 外层循环， 拿到a

            if (nums[i] > 0) return res;

            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // 恰好匹配到 一个
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 排序后可能出现重复数字， 但是我们不需要加上
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    // update left and right
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

}
