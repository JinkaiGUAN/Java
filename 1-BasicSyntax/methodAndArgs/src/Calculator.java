/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
import java.util.Arrays;


public class Calculator {
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int sum(int num1, int num2) {
        // With the modifier `static`, we can use this method without any class name specified. However, if you do not
        // use `static`, you have to initialize a instance so that this method can be used.
        return num1 + num2;
    }

    public static float sum(float num1, float num2) {
        // overloading
        return num1 + num2;
    }

    public static int[] sumList(int[] array1, int[] array2) {
        int[] sums = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            sums[i] = array1[i] + array2[i];
        }
        return sums;
    }


    public static void main(String[] args) {
//        int num = 7;
//
//        if (isEven(num)) {
//            num = sum(num, 1);
//        } else {
//            num = sum(num, -1);
//        }
//        System.out.println(num + ",");

        int[] array1 = {1, 5, 8, 9};
        int[] array2 = {2, 4, 8, 1};
        int[] sumArray = sumList(array1, array2);
        System.out.println(Arrays.toString(sumArray));
    }


}

