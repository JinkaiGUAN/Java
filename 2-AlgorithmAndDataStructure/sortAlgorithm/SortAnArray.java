import java.util.Arrays;

/**
 * @author: Peter
 * @date: 29/12/2021
 * @description: https://leetcode.com/problems/sort-an-array/
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
//        insertSort(nums);
        quickSort(nums, 0, nums.length - 1);
//        mergeSort(nums);
        return nums;
    }

    /**
     * 插入排序
     * @param array
     */
    public void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int cur = array[i];  // 储存当前元素
            int j = i - 1; // 控制向左移动下标
            while (j >= 0 && array[j] > cur) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = cur;
        }
    }

    /**
     * 快速排序。
     *
     * @param array
     * @param left
     * @param right
     */
    public void quickSort(int[] array, int left, int right) {
        if (left > right) return;

        // 获取分割排序之后的基准数的index
        int partitionIdx = partition(array, left, right);
        quickSort(array, left, partitionIdx - 1);
        quickSort(array, partitionIdx + 1, right);

    }

    /**
     * 获取pivot在分割之后的下标， 作为下一次分割的标记。
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] array, int left, int right) {
        int pivot = array[right];  // subarray 当中最后一个元素作为基准；

        int smallerElementIdx = left;
        int biggerElementIdx = right - 1;

        while (true) {
            // 从左到右寻找大于pivot的数的下标
            while (smallerElementIdx < right && array[smallerElementIdx] <= pivot) {
                smallerElementIdx++;
            }

            // 从右到左寻找小于pivot的数的下标
            while (biggerElementIdx >= left && array[biggerElementIdx] > pivot) {
                biggerElementIdx--;
            }
            if (smallerElementIdx > biggerElementIdx) break; // 越界 说明排序完成

            swap(array, smallerElementIdx, biggerElementIdx); // 交换元素， 使得小的元素在左侧， 大的元素在右侧
        }

        swap(array, smallerElementIdx, right); // smallerElementIdx 是大于pivot的第一个元素

        return smallerElementIdx;
    }

    /**
     * 交换元素。
     *
     * @param array
     * @param left
     * @param right
     */
    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    /**
     * 归并排序。
     *
     * @param array
     */
    public void mergeSort(int[] array) {
        int[] helper = copy(array);
        mergeSort(array, helper, 0, array.length - 1);
    }

    public void mergeSort(int[] array, int[] helper, int start, int end) {
        // 划分array
        if (start >= end) return; // 子数组未一个数
        int mid = start + (end - start) / 2;

        mergeSort(array, helper, start, mid);
        mergeSort(array, helper, mid + 1, end);

        // 合并
        merge(array, helper, start, mid, end);

    }

    public void merge(int[] array, int[] helper, int start, int mid, int end) {
        if (end + 1 - start >= 0) System.arraycopy(array, start, helper, start, end + 1 - start);

        int leftStart = start;
        int rightStart = mid + 1;

        for (int i = start; i <= end; i++) {
            if (leftStart > mid) {
                array[i] = helper[rightStart++];
            } else if (rightStart > end) {
                array[i] = helper[leftStart++];
            } else if (helper[leftStart] < helper[rightStart]) {
                array[i] = helper[leftStart++];
            } else {
                array[i] = helper[rightStart++];
            }
        }

    }


    public int[] copy(int[] array) {
        int[] newArray = new int[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);

        return newArray;
    }


    public static void main(String[] args) {
        int[] array = {1, 7, 4, 6, 3, 2, 8, 9, 5, 6};
//        int[] array = {2, 0, 2, 1, 1, 0};

        SortAnArray sortArr = new SortAnArray();
        sortArr.sortArray(array);
        System.out.println(Arrays.toString(array));
    }

}
