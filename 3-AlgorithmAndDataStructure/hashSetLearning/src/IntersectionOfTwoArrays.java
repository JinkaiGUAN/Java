import java.util.Set;
import java.util.HashSet;

/**
 * @author: Peter
 * @date: 01/01/2022
 * @description:
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 使用一个set， 将nums1中所有元素都存进set中， 然后逐步判断nums2中元素在是否存在set
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};

        Set<Integer> table1 = new HashSet<Integer>();
        Set<Integer> table2 = new HashSet<Integer>();


        for (int num : nums1) {
            table1.add(num);
        }
        for (int num : nums2) {
            table2.add(num);
        }

        table1.retainAll(table2);
        int[] res = new int[table1.size()];
        int idx = 0;
        for(int num : table1) {
            res[idx++] = num;
        }

        return res;
    }


}
