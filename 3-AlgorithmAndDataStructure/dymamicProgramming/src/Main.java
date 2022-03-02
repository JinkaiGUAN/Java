import java.util.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: Main
 * Author:   Peter
 * Date:     02/03/2022 17:30
 * Description:
 * History:
 * Version:
 */


public class Main {

    public static void main(String[] args) {
        // Get data
        Scanner scanner = new Scanner(System.in);
        int consumerNum = Integer.parseInt(scanner.nextLine());
        if (consumerNum == 0) {
            System.out.println(0);;
        }

        int[] points = new int[2 * consumerNum];
        for (int i = 0; i < 2 * consumerNum; i++) {
            points[i] = scanner.nextInt();
        }

        // sort unique points
        Set<Integer> set = new TreeSet<>();
        for (int point : points) {
            set.add(point);
        }

        // add to map
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int point : set) {
            map.put(point, index++);
        }

        // go through all points
        int[] cover = new int[map.size() + 1];
        for (int i = 0; i < points.length; i+=2) {
            ++cover[map.get(points[i])];
            --cover[map.get(points[i+1]) + 1];
        }


        /*
        5.calculate cumulative sums
         */
        int sum = 0;
        int max = 0;
        for (int i = 0; i < cover.length; i++) {
            cover[i] = (sum += cover[i]);
            if (cover[i] > max)
                max = cover[i];
        }

        /*
        6.get result int mapped array
         */
        int startIndex = 0, endIndex = 0, maxLength = 0;
        for (int i = 0; i < cover.length; i++) {
            if (cover[i] == max){
                if (startIndex == 0)
                    startIndex = i;
                ++maxLength;
            }
        }
        endIndex = startIndex + maxLength - 1;

        /*
        7.retrieve result in original points
         */
        int start = 0, end = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == startIndex)
                start = entry.getKey();
            else if (entry.getValue() == endIndex)
                end = entry.getKey();
        }

        System.out.println("The maximum interval overlap is : " + max);
        System.out.println("[" + start + ", " + end + "]");

    }
}

class Interval {
    public int type;
    public int val;

    public Interval(int type, int val) {
        this.type = type;
        this.val = val;
    }
}

