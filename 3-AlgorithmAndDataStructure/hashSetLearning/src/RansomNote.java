import java.util.Map;
import java.util.HashMap;

/**
 * @author: Peter
 * @date: 02/01/2022
 * @description:
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 使用hashMap， 将两个string都存入， key为字母char， value为其出现的次数， 我们对比两个hashmap的数据

        Map<Character, Integer> table = new HashMap<Character, Integer>();
        Map<Character, Integer> tableMagazine = new HashMap<Character, Integer>();

        for (int i = 0; i < ransomNote.length(); i++) {
            table.put(ransomNote.charAt(i), table.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char letter = magazine.charAt(i);
            tableMagazine.put(letter, tableMagazine.getOrDefault(letter, 0) + 1);
        }

        for (char letter: table.keySet()) {
            int numRansomNote = table.getOrDefault(letter, 0);
            int numMagazine = tableMagazine.getOrDefault(letter, 0);
            if (numRansomNote > numMagazine) return false;

        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) return false;

        int[] cnt = new int[26];

        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c: ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) return false;
        }

        return true;

    }

}
