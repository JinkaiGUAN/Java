import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Peter
 * @date: 03/01/2022
 * @description:
 */
public class FourSumSingleArray {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 此时我们仍然采用双指针的思想， 但是在外层我们会多嵌套一个循环， 用来寻找最外层的数据
        // 注意我们可能遇到[2, 2, 2, 2]这样的数据
        List<List<Integer>> res = new ArrayList<>();
        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // 为了确保能找到第二个数， 我们i只能取【0， n-1-1】，
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < nums.length; j++) {

                // 前面两个数相加大于target， 直接退出, 注意 此时我们不能这么做，因为 target为任意值， 无法判断之后数的正负关系
//                if (nums[i] + nums[j] > target) return res;

                // 如果 i和j表示的元素一致， 我们也跳过着一层
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 跳过重复的left and right
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        // update the left and right;
                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[] {2, 2, 2, 2};
        int target = 8;

        FourSumSingleArray solution = new FourSumSingleArray();
        solution.fourSum(array, target);
    }

}
