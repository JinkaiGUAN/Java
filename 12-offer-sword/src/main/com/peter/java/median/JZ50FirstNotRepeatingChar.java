package main.com.peter.java.median;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ50FirstNotRepeatingChar
 * Author:   Peter
 * Date:     29/04/2022 21:08
 * Description: https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ50FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // string character
        Queue<Character> q1 = new LinkedList<Character>();
        // character position
        Queue<Integer> q2 = new LinkedList<Integer>();

        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                // exclude this character
                map.put(str.charAt(i), 1);
                q1.offer(str.charAt(i));
                q2.offer(i);
            } else {
                map.put(str.charAt(i), -1);
                while (!q1.isEmpty() && map.get(q1.peek()) == -1) {
                    q1.poll();
                    q2.poll();
                }
            }
        }

        return q2.isEmpty() ? -1 : q2.poll();
    }

    public int FirstNotRepeatingChar2(String str) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
