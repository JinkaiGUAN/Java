import java.awt.image.MultiPixelPackedSampleModel;

/**
 * @author: Peter
 * @date: 28/12/2021
 * @description: https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 先用二分法找到该元素所属行， 再用二分法查找该元素所属column

        // special case: 空矩阵， 只有一行元素， target在matrix搜索外
        // matrix is None
        if ((matrix == null || matrix.length == 0) || (matrix.length == 1 && matrix[0].length == 0)){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        // target 不在搜索范围内
        if (target < matrix[0][0] || target > matrix[row - 1][column - 1]) {
            return false;
        }

        // 1. 找到target所在区间
        int[] range = new int[row + 1];
        for (int i = 0; i < row; i++) {
            range[i] = matrix[i][0];
        }
        // 排除可能有target恰好时matrix的最后一个元素， 将其包含在内
        range[range.length - 1] = matrix[row - 1][column - 1] + 1;

        // 比target稍大的最小index
        int upperIndex = binarySearchForRange(range, target);

        //2. 查找target是否在改行内
        return binarySearchForTarget(matrix[upperIndex - 1], target);

    }

    public boolean binarySearchForTarget(int[] array, int target) {
        // 查找某一行是否有一个元素

        // 保证至少有一个元素
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public int binarySearchForRange(int[] array, int target) {
        // 查找当前元素的范围， 即找到比target稍微大的元素的下标,

        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        int target = 3;

//        int [][] matrix = {{1}};
//        int target = 1;
//
        int [][] matrix = {{1}, {3}};
        int target = 3;
        Search2DMatrix search = new Search2DMatrix();
        System.out.println(search.searchMatrix(matrix, target));

    }

}
