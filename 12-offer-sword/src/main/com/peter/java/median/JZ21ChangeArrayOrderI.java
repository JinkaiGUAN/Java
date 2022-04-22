package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ21ChangeArrrayOrderI
 * Author:   Peter
 * Date:     19/04/2022 22:42
 * Description: 调整数组顺序使奇数位于偶数前面
 * History:
 * Version:
 * @author Peter
 */
public class JZ21ChangeArrayOrderI {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * In this method, two pointer method is going to be used.
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        // write code here
        int fast = 0;
        int slow = 0;

        while (fast < array.length) {
            if ((array[fast] % 2) == 1) {
                int temp = array[fast];

                for (int i = fast - 1; i >= slow; i--) {
                    array[i + 1] =  array[i];
                }
                array[slow] = temp;

                slow++;
            }

            fast++;
        }

        return array;
    }

}
