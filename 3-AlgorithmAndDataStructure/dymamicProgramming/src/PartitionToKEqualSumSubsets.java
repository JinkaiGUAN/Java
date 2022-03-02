import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: PartitionToKEqualSumSubsets
 * Author:   Peter
 * Date:     01/03/2022 12:18
 * Description: https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 * History:
 * Version:
 */
public class PartitionToKEqualSumSubsets {
//    static List<List<Integer>> res = new LinkedList<>();
//    static LinkedList<Integer> path = new LinkedList<>();
    private static boolean[] used;
    private static int k;
    private static int count;

//    public PartitionToKEqualSumSubsets() {
//        PartitionToKEqualSumSubsets.count++;
//
//    }

    /**
     * final x = new byte[];， 不可变是针对什么而言
     * string: immutable,
     * static, instance 可以同时访问， 同步问题
     * 用stream替代for loop
     */

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please input the list");
//        String s = scanner.nextLine();
//        System.out.println("Please input a splitting integer");
//
//        int k = scanner.nextInt();
//        int[] nums = parseStringToIntArr(s);
        PartitionToKEqualSumSubsets solution = new PartitionToKEqualSumSubsets();

        int[] nums = new int[] {4, 3, 2, 3, 5, 2, 1};
        k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
//        String
    }

    public static boolean canPartitionKSubsets(int[] nums, int k_) {
        int sum = calSum(nums);
        k = k_;

        if (sum % k != 0) return false;
        int target = sum / k;  // cannot be zero since it is a positive list

        Arrays.sort(nums);
        used = new boolean[nums.length];

        backTracking(nums, target, 0, 0);

        System.out.println(k + "--" );
        return k == 0;
    }

    public static int[] parseStringToIntArr(String s) {
        if (s.isEmpty()) return null;

        String[] strArr = s.split(" ");
        int strLen = strArr.length;

        int[] res = new int[strLen];
        for (int i = 0; i < strLen; i++) {
            try {
                res[i] = Integer.parseInt(strArr[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    public static void backTracking(int[] nums, int target, int startIdx, int sum) {
        if (sum == target) {
            System.out.println(sum);
            k--;
            System.out.println("k : " + k);
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            // todo: sort is necessary
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                // 表示当前元素已经重复
                continue;
            }
            if ((sum + nums[i]) > target) return;

            used[i] = true;
            System.out.println(i + " --- >"+sum);
            sum += nums[i];
            System.out.println("--- >"+sum);

            backTracking(nums, target, i + 1 , sum);

            sum -= nums[i];
            used[i] = false;
        }
    }

//    public static boolean backTracking(int[] nums, int target, int startIdx, int k, int sum) {
//        if (sum == target) {
//            System.out.println(sum);
//            k--;
//            return k == 0;// 当前下方的元素没有必要继续探索
//        }
//
//        for (int i = startIdx; i < nums.length; i++) {
//            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
//                // 表示当前元素已经重复
//                continue;
//            }
//
//            if ((sum + nums[i]) > target) return false;
//
//            used[i] = true;
//            System.out.println(i + " --- >"+sum);
//            sum += nums[i];
//            System.out.println("--- >"+sum);
//
//            backTracking(nums, target, i + 1, k , sum);
//
//            sum -= nums[i];
//            used[i] = false;
//
//        }
//
//        return false;
//    }

    private static int calSum(int[] nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }

        return sum;
    }

    private static int calSum(LinkedList<Integer> nums) {
        if (nums.isEmpty()) return 0;

        int length = nums.size();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums.removeLast();
        }

        return sum;
    }
}
