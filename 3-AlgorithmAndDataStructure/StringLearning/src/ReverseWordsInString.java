import java.util.Deque;
import java.util.ArrayDeque;

/**
 * @author: Peter
 * @date: 05/01/2022
 * @description: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        // 先使用双指针 确认字符串两边空格的位置， 即确认起始和种植字符位置，
        // 将整个字符串反转， 然后逐个单词反转
        if (s == null || s.length() == 0) return s;

        // clear free whitespace
        String oldString = trimSpaces(s).toString();
        char[] newArray= oldString.toCharArray();

        // 反转截取之后的字符
        reverseCharArray(newArray, 0, newArray.length - 1);

        // 反转每个单词
        int start = 0, end = 0;
        while (end <= newArray.length) {

            if (end == newArray.length || newArray[end] == ' ' ) {
                reverseCharArray(newArray, start, end - 1);
                // Using loop to filter more whitespace between two words and assign the start to the first index
                // of the next word.
                start = end;  // assign the start index to the end
                while (start < newArray.length && newArray[start] == ' ') {
                    start++;
                    end++;
                }
            }
            end++;
        }

        return new String(newArray);
    }

    public String reverseWords2(String s) {
        // This method used deque to solve the problem
        int left = 0, right = s.length() - 1;

        // trim whitespace
        while (left <= right && s.charAt(left) == ' ') ++left;
        while (right >= left && s.charAt(right) == ' ') --right;

        Deque<String> deque = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);

            if (word.length() != 0 && c == ' ') {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        deque.offerFirst(word.toString());

        return String.join(" ", deque);

    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;

        // trim the redundant whitespace in the left part.
        while (left <= right && s.charAt(left) == ' ') left++;

        // trim the redundant whitespace in the right part
        while (right >= left && s.charAt(right) == ' ') right--;

        // trim the whitespace between the words
        // todo: StringBuilder is not thread safe class in Java, use StringBuffer instead.
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;

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
        String str = "  the  sky s blue   ";

        ReverseWordsInString solution = new ReverseWordsInString();
        System.out.println(solution.reverseWords2(str)); // expected: "blue is sky the"
    }
}
