/**
 * @author: Peter
 * @date: 11/01/2022
 * @description: https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
//        if (nums == null || nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 3};
        int val = 3;

        RemoveElement solution = new RemoveElement();
        System.out.println(solution.removeElement(nums, val));
    }
}
