/**
 * @author: Peter
 * @date: 28/12/2021
 * @description:
 */

import java.util.Arrays;


public class SortAlgo {
    /**
     * 在插入排序中， 物品们从前到后一次处理未拍好的元素， 对于每个元素， 我们将它与之前排好序的元素进行比较， 找到对应的位置后插入。 本质上，
     * 对于每一个要被处理的元素， 我们只关心它与之前元素的关系， 当前元素之后的元素我们下一轮才去处理。
     *
     * @param arr
     */
    public void insertSort(int[] arr) {
        // 插入排序， O(n^2)


        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int insertionIdx = i - 1;

            while (insertionIdx >= 0 && arr[insertionIdx] > cur) {
                arr[insertionIdx + 1] = arr[insertionIdx];
                insertionIdx--;
            }
            arr[insertionIdx + 1] = cur;
        }
    }

    /**
     * 快速排序是一种分冶(divide and conquer)算法， 在这种算法中， 我们吧大问题变成小问题， 然后将小问题组个解决， 当小问题解决完时，
     * 大问题也会被解决。
     * <p>
     * 快排基本概念就是选取一个目标元素， 然后将目标元素放到数组中正确的位置。 然后根据排好序后的元素， 将数组切分未两个子数组， 用相同的方法，
     * 在没有排序的范围使用相同的操作。
     * <p>
     * 具体步骤：
     * <p>
     * 1. 对于当前数组， 取最后一个元素做基数(pivot)。
     * <p>
     * 2. 将所有比基数小的元素排到基准数之前， 比基准数大的排在基准数之后。
     * <p>
     * 3. 当基准数被放到准确的位置之后， 根据基准数的位置将元素切分未前后两个子数组。
     * <p>
     * 4. 对于子数组采用步骤1-4的递归操作， 知道子数组的非常堵小于等于1为止。
     * <p>
     * 时间复杂度： O(n^2), 平均时间复杂度: O(nlogn).
     *
     * @param array
     */
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int partitionIndex = partition(array, left, right);
        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
    }

    public int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int leftIndex = left;
        int rightIndex = right - 1;
        while (true) {
            // 寻找比pivot大的数
            while (leftIndex < right && array[leftIndex] <= pivot) {
                leftIndex++;
            }
            // 寻找比pivot小的数
            while (rightIndex >= left && array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex > rightIndex) break;
            swap(array, leftIndex, rightIndex);
        }
        swap(array, leftIndex, right); // swap pivot to the right position
        return leftIndex;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    /**
     * 归并排序时一种基于归并操作的有效排序算法。 在此算法中， 我们将一个数组分为两个子数组， 通过递归重复将组织切分到只身下一个元素为止。
     * 然后将每个子数组中的元素排序后合并， 通过不断合并子数组， 最后就会拿到一个排好序的大数组。
     * <p>
     * 归并排序和快排一样， 也是一种分冶算法。 其中主要包括两个步骤：
     * <p>
     * 1. 切分步骤： 将大问题变为小文题， 通过递归解决更小的子问题。
     * <p>
     * 2. 解决步骤： 将小问题的结果合并， 以此找到大问题的答案。
     * <p>
     * 递归具体步骤：
     * <p>
     * 1. 递归切分当前数组。
     * <p>
     * 2. 如果当前数组数量小于等于1， 无需排序， 直接返回结果。
     * <p>
     * 3. 否则将当前数组分为两个子数组， 递归排序这两个子数组。
     * <p>
     * 4. 在子数组排序结束后， 将子数组的结果归并成排好序的数组。
     * <p>
     * 时间复杂度: O(nlogn)
     *
     * @param array
     */
    public void mergeSort(int[] array) {
        int[] helper = copy(array);
        mergeSort(array, helper, 0, array.length - 1);

    }

    public void mergeSort(int[] array, int[] helper, int left, int right) {
        if (right - left < 1) return;
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    public void merge(int[] array, int[] helper, int left, int mid, int right) {
        if (right + 1 - left >= 0) System.arraycopy(array, left, helper, left, right + 1 - left);

        int leftStart = left;
        int rightStart = mid + 1;
        for (int i = left; i <= right; i++) {
            if (leftStart > mid) {
                array[i] = helper[rightStart++];
            } else if (rightStart > right) {
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
        int[] array = new int[]{1, 5, 6, 3, 2, 7, 9, 8, 4};

        SortAlgo sortAl = new SortAlgo();
//        sortAl.insertSort(array);
//        sortAl.quickSort(array, 0, array.length - 1);
        sortAl.mergeSort(array);
        System.out.println(Arrays.toString(array));

    }
}
