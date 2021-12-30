/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
public class binarySearch {

    public int binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int binarySearch2(int[] nums, int start, int end, int target) {
        // recursion

        if (end >= start) {
            int mid = start + (start - end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return binarySearch2(nums, start, mid - 1, target);
            }
            return binarySearch2(nums, mid + 1, end, target);
        }

        return -1;
    }

    public static void main(String[] argss) {
        binarySearch bs = new binarySearch();
        int[] array = new int[] {1, 2, 3, 5, 7, 9};

        bs.binarySearch(array, 5);
    }
}
