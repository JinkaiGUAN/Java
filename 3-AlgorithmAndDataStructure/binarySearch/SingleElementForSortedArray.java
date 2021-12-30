/**
 * @author: Peter
 * @date: 28/12/2021
 * @description: https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-leetcode/
 */
public class SingleElementForSortedArray {
    public int singleNonDuplicate(int[] nums) {
        // 采用二分法， 第一步找到当前的元素， 并且判断current element两端元素的奇偶性

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isHalfEven = (right - mid) % 2 == 0;

            if (nums[mid + 1] == nums[mid]) {
                // 当前元素与右侧元素相同
                if (isHalfEven) {
                    // 右侧剩下元素为记述， left updating
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                // 当前元素与左侧元素相同
                if (isHalfEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[left];
    }

    public int singleNonDuplicate2(int[] nums) {
        // 该方法只寻找偶数下标， 因为偶数下标两侧数组个数都为偶数， 此时只要判断当前下标后方与当前元素是否一致， 若是一致， 那么出现一次的元素
        // 就在右侧， 否则在左侧。 当当前下标为 奇数的时候， 我们左移一位 让其变为偶数。

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid + 1] == nums[mid]) {
                left = mid + 2;
            } else {
                right = mid;
            }

        }

        return nums[left];
    }
}
