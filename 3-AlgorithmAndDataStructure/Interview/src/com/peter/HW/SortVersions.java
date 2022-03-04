package com.peter.HW;

import java.util.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: SortVersions
 * Author:   Peter
 * Date:     03/03/2022 13:42
 * Description: We are going to input a sequence of versions, and you need to sort them accoring to the rules we
 * provide and output them.
 * History:
 * Version:
 */
public class SortVersions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // collect how many version string we would have
        int num = Integer.parseInt(scanner.nextLine());

        // collecting the version sequence
        String[] versions = new String[num];
        for (int i = 0; i < num; i++) {
            versions[i] = scanner.nextLine();
//            System.out.println(i + " " + versions[i]);
        }

        System.out.println(Arrays.toString(versions));

        List<String> sortedVersions = sortVersion(versions);
        System.out.println(sortedVersions.toString());


        // 1.0.1
        // .1.1
        // 1.1.1

    }

    private static List<String> sortVersion(String[] versions) {
        // This is for descending order
        Map<Double, String> treeMap = new TreeMap<Double, String>(Comparator.reverseOrder());
        // This is for ascending order
//        Map<Double, String> treeMap = new TreeMap<Double, String>();

        for (String version : versions) {
            String[] str = version.split("\\.");
            System.out.println(Arrays.toString(str));

            // transfer the version string to the double value
            double key = 0.0;
            for (int i = 0, j = 2; i < 3 && j >= -1; i++, j--) {
                if (str[i].equals("")) {
                    key += 0;
                } else {
                    key += Double.parseDouble(str[i]) * Math.pow(10.0, 3 * j);
                }
            }

//           sort the version, this is from low to high, we need to get from high to low
            treeMap.put(key, version);
        }


        List<String> res = new LinkedList<>();
        for (Double key : treeMap.keySet()) {
            String val = treeMap.get(key);
            res.add(val);
        }

        return res;
    }
}
