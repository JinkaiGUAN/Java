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

        System.out.println(Arrays.toString(points));

        // sort unique points
        Set<Integer> set = new TreeSet<>();
        for (int point : points) {
            set.add(point);
        }

        // add to map
        Map<Integer, Integer> map = new HashMap<>();  // key is the point x value, the value is the index of the point
        int index = 0;
        for (int point : set) {
            map.put(point, index++);
        }
        // 10 15 55 60 10 40 5 15 5 10 25 55
        System.out.println(map); // {5=0, 55=5, 40=4, 25=3, 10=1, 60=6, 15=2}

        // go through all points
        int[] cover = new int[map.size() + 1];
        for (int i = 0; i < points.length; i+=2) {
            System.out.println("start: " + map.get(points[i]));
            ++cover[map.get(points[i])];  // start
            System.out.println("end: "+ (map.get(points[i+1]) + 1));
            // todo: drop the sesame at the exact end of the range,i.e.,
            --cover[map.get(points[i+1])];
//            --cover[map.get(points[i+1]) + 1]; // end

        }

        System.out.println("covers: " + Arrays.toString(cover));  // [2, 2, -1, -1, 0, 0, -1, -1]

        /*
        5.calculate cumulative sums, i.e., the maximum range number we have experienced.
         */
        int sum = 0;
        int max = 0;
        for (int i = 0; i < cover.length; i++) {
            cover[i] = (sum += cover[i]);
            if (cover[i] > max)
                max = cover[i];
        }

        System.out.println("Consum: " + Arrays.toString(cover));  // [2, 4, 3, 2, 2, 2, 1, 0]

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
        // todo: I suppose we do not need to minus 1 here to gain the endIdx, since we count the maxLength from 0.
        endIndex = startIndex + maxLength; // - 1;

        System.out.println("StartIdx " + startIndex + " endIdx " + endIndex);

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

