/**
 * Copyright (C), Peter GUAN
 * FileName: FibonacciNumber
 * Author:   Peter
 * Date:     26/02/2022 11:36
 * Description: https://leetcode-cn.com/problems/fibonacci-number/
 * History:
 * Version:
 */
public class FibonacciNumber {
    public int fib(int n ) {
        if (n == 0)  return 0;
        if (n == 1)  return 1;

        int F1 = 1;  // f(n - 1)
        int F2 = 0; // f(n - 2)
        int Fn = F1 + F2;

        for (int i = 1; i < n; i ++) {
            Fn = F1 + F2;
            // update f(n - 1) and f(n - 2)
            F2 = F1;
            F1 = Fn;
        }

        return Fn;

    }
}
