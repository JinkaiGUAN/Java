/**
 * Copyright (C), Peter GUAN
 * FileName: candy
 * Author:   Peter
 * Date:     23/02/2022 23:02
 * Description: https://leetcode-cn.com/problems/candy/
 * History:
 * Version:
 */
public class candy {
    public int candy(int[] ratings) {
        // assign one for each person
        int[] candies = new int[ratings.length];
//        for (int i = 0; i < ratings.length; i++) {
//            candies[i] = 1;
//        }

        // rank children from left to right
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }



        // rank the children from right ro left
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }

        // count total candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}
