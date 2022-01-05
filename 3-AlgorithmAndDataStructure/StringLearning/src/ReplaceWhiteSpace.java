import java.util.Arrays;

/**
 * @author: Peter
 * @date: 05/01/2022
 * @description: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceWhiteSpace {

    public String replaceSpace(String s) {
        // 方法一， 直接使用String模块内置方法 str.replace(" ", "%20"). 较为直接， 不推荐.
        // 方法二， 双指针， 第一步扫描得到空格数目， 然后构建一个charr【】数组储存

        if ( s == null || s.length() == 0) return s;

        // 统计空格数量
        int whiteSpaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                whiteSpaceCount++;
            }
        }

        // 没有空格
        if (whiteSpaceCount == 0) return s;

        // 替换空格
        char[] newArray = new char[s.length() + whiteSpaceCount * 2];
        // copy array
        char[] array = s.toCharArray();
        System.arraycopy(array, 0, newArray, 0, s.length());

        int left = s.length() - 1;  // 最后一个字符位置
        int right = newArray.length - 1; // 新数组的最后一个位置

        while (left>=0) {

            if (newArray[left] != ' ') {
                newArray[right--] = newArray[left--];
            } else {
                newArray[right--] = '0';
                newArray[right--] = '2';
                newArray[right--] = '%';
                left--;
            }

        }

        return new String(newArray);

    }

    public static void main(String[] args) {
        String str = "We are happy.";

        ReplaceWhiteSpace solution = new ReplaceWhiteSpace();
        System.out.println(solution.replaceSpace(str));


    }

}
