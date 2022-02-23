/**
 * Copyright (C), Peter GUAN
 * FileName: LemonadeChange
 * Author:   Peter
 * Date:     23/02/2022 23:13
 * Description: https://leetcode-cn.com/problems/lemonade-change/
 * History:
 * Version:
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (ten <= 0 && five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }

                twenty++;
            }
        }

        return true;
    }
}
