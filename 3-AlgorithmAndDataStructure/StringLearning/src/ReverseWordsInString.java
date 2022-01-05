/**
 * @author: Peter
 * @date: 05/01/2022
 * @description:
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        // 先使用双指针 确认字符串两边空格的位置， 即确认起始和种植字符位置，
        // 将整个字符串反转， 然后逐个单词反转
        if (s == null || s.length() == 0) return s;

        // clear free whitespace
        int left = getBound(s, 0, true);
        int right = getBound(s, s.length() - 1, false); // 最右侧不是空格的下标

        char[] oldStringArray = s.toCharArray();
        char[] newArray = new char[right - left + 1];
        if (right + 1 - left >= 0) System.arraycopy(oldStringArray, left, newArray, left - left, right + 1 - left);

        // 反转截取之后的字符
        reverseCharArray(newArray, 0, newArray.length - 1);

        // 反转每个单词
        int start = 0, end = 0;
        while (end < newArray.length) {

            if (newArray[end] == ' ') {
                reverseCharArray(newArray, start, end - 1);
                start++;
            }
            end++;
        }

        return new String(newArray);

    }

    public int getBound(String s, int startIdx, boolean lower) {
        // 返回的是第一个不是空格的元素下标， 或者是最后一个不是空格元素的下标
        while ((startIdx < s.length() && lower) || (!lower && startIdx >= 0)) {
            char letter = s.charAt(startIdx);
            if (letter == ' ') {
                startIdx = lower ? startIdx + 1 : startIdx - 1;
            } else {
                break;
            }
        }

        return startIdx;
    }

    public void reverseCharArray(char[] array, int left, int right) {
        // reverse the array in the range of [left, right]
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String str = "the sky is blue";

        ReverseWordsInString solution = new ReverseWordsInString();
        //todo: figure out the bug.
        System.out.println(solution.reverseWords(str)); // expected: "blue is sky the"
    }
}
