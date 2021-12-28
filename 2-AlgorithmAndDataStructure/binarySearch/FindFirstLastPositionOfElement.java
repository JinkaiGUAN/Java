/**
 * @author: Peter
 * @date: 28/12/2021
 * @description:
 */
public class FindFirstLastPositionOfElement {

    public int[] searchRange(int[] nums, int target) {
        int[] constArr = {-1, -1};

        // 二分法查找上下界， 上界查找第一个比target要大的idx， 下界查找第一个小于 target的index
        int upperBound = searchUpper(nums, target) - 1;  // -1
        int lowerBound = searchLower(nums, target);


        if (lowerBound <= upperBound && upperBound < nums.length && nums[lowerBound] == target) {
            return new int[] {lowerBound, upperBound};
        }

        return constArr;
    }

    public int searchUpper(int[] nums, int target) {
        // return the upper bound. --> 第一个大于target的下标
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int searchLower(int[] nums, int target){
        // return the lower bound. --> 恰好是target
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

}
