import java.util.*;


/**
 * Copyright (C), Peter GUAN
 * FileName: WordBreak
 * Author:   Peter
 * Date:     12/03/2022 23:08
 * Description: https://leetcode-cn.com/problems/word-break/
 * History:
 * Version:
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 单词就是物品， 
        // dp[i] 表示字符串长度为i的话， dp[i] 为true， 表示可以拆分为一个或者多个在字典中出现的单词
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            // 外层背包
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (wordDict.contains(word) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return  valid[s.length()];
    }

    public boolean backTracking(String s, Set<String> wordDict, int startIdx, int[] memory) {
        if (startIdx >= s.length()) {
            return true;
        }
        if  (memory[startIdx] != 0) {
            // 此处认为：memory[i] = 1 表示可以拼出i 及以后的字符子串， memory[i] = -1 表示不能
            return memory[startIdx] == 1 ? true : false;
        }

        for (int i = startIdx; i < s.length(); i++) {
            String word = s.substring(startIdx, i+1);
            if (wordDict.contains(word) && backTracking(s, wordDict, i + 1,memory)) {
                memory[startIdx] = 1;
                return true;
            }
        }

        memory[startIdx] = -1;
        return false;
    }

    public static  void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        String  s = scanner.nextLine();

        String[] strs = scanner.nextLine().split(" ");
        List<String> list = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }

        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak(s, list));

        // 回溯
        Set<String> wordDict = new HashSet<>(strs);
        int[] memory = new int[s.length()];
        System.out.println(solution.backTracking(s, wordDict, 0, memory));

    }


}