import java.util.Set;
import java.util.HashSet;

/**
 * @author: Peter
 * @date: 01/01/2022
 * @description: https://leetcode-cn.com/problems/happy-number/
 */
public class HappyNumber {
    // 题目说会出现无线循环， 也就是在出现循环时， 我们立即断开 返回false， 如果可以变成1 则返回true。
    public boolean isHappy(int n){
        // 使用set 完成数字是否重复的验证
        Set<Integer> visited = new HashSet<Integer>();
        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy2(int n) {
        // 快慢指针
        int slowPointer = n;
        int fastPointer = getNext(n);

        while (fastPointer != 1 && slowPointer != fastPointer) {
            slowPointer = fastPointer;
            fastPointer = getNext(getNext(slowPointer));
        }

        return fastPointer == 1;
    }
}
