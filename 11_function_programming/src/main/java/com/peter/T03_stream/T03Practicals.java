package main.java.com.peter.T03_stream;

import main.java.com.peter.entity.Artist;

import java.util.*;
import java.util.stream.Stream;

/**
 * Copyright (C), Peter GUAN
 * FileName: T03Praticals
 * Author:   Peter
 * Date:     09/04/2022 10:24
 * Description: 课后练习
 * History:
 * Version:
 *
 * @author Peter
 */
public class T03Practicals {

    public void Q2(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }

        // Refactor
        int number = (int) artists.stream()
                .flatMap(artist -> artist.getMembers())
                .count();
    }

    public int Q6(String s) {
        //String s = "aduaHadoajFGGUAG";

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                count++;
            }
        }

        // refactor
        int number = (int) s.chars()
                .filter(Character::isLowerCase)
                .count();

        return count;
    }

    public Optional<String> Q7() {
        String[] strings = new String[] {"ha", "hadGO", "haudFY"};

        int max = 0;
        String maxStr = null;
        for (String str : strings) {
            int count = (int) str.chars().filter(Character::isLowerCase).count();
            if (count > max) {
                maxStr = str;
            }
        }

        return Arrays.asList(strings).stream()
                .max(Comparator.comparingInt(this::Q6));
    }

}
