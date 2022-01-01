import java.util.Map;
import java.util.HashMap;

/**
 * @author: Peter
 * @date: 01/01/2022
 * @description:
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // 根据异位词， 我们可以统计每一个字符串中间字母出现的频率。 统计之后我们一次比较key， 但是对出现这种情况， key索引取值都一样，
        // 但是有一个map中key较多。
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();

        // get the character frequency
        for (int i = 0;  i < s.length(); i++) {
            char singleS = s.charAt(i), singleT = t.charAt(i);

            mapS.put(singleS, mapS.getOrDefault(singleS, 0) + 1);
            mapT.put(singleT, mapT.getOrDefault(singleT, 0) + 1);
        }

        if (mapT.size() != mapS.size()) return false;

        for (char singleS: mapS.keySet()) {
            if (!mapS.get(singleS).equals(mapT.get(singleS))) return false;
        }

        for (char singleT: mapT.keySet()) {
            if (!mapT.get(singleT).equals(mapS.get(singleT))) return false;
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] table = new int[26];

        for(int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) return false;
        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char singleS = s.charAt(i);
            table.put(singleS, table.getOrDefault(singleS, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char singleT = t.charAt(i);
            table.put(singleT, table.getOrDefault(singleT, 0) + 1);
            if (table.get(singleT) < 0) return false;
        }

        return true;
    }



}
