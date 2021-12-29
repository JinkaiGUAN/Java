import java.util.Arrays;

/**
 * @author: Peter
 * @date: 29/12/2021
 * @description: https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) return;

        int partitionIdx = partition(nums, left, right);
        quickSort(nums, left, partitionIdx - 1);
        quickSort(nums, partitionIdx + 1, right);

    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int leftStart = left;
        int rightStart = right - 1;

        while (true) {
            // 找寻左侧较大的数
            while (leftStart < right && nums[leftStart] <= pivot) {
                leftStart++;
            }
            // 找到右侧较小的数
            while (rightStart >= left && nums[rightStart] > pivot) {
                rightStart--;
            }

            if (leftStart > rightStart) break;

            swap(nums, leftStart, rightStart);
        }

        swap(nums, leftStart, right);

        return leftStart;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 1, 0};

        SortColors sc = new SortColors();
        sc.sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
