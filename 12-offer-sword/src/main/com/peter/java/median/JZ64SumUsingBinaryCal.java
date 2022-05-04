package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ64SumUsingBinaryCal
 * Author:   Peter
 * Date:     04/05/2022 19:02
 * Description: https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=265&tqId=39259&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265&difficulty=undefined
 * &judgeStatus=undefined&tags=&title=
 * History:
 * Version:
 */
public class JZ64SumUsingBinaryCal {
    public int Sum_Solution(int n ) {
        boolean flag = (n > 0) && ( (n += Sum_Solution(n - 1)) > 0);

        return n;
    }

}
