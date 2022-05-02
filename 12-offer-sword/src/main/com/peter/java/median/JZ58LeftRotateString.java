package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ58LeftRotateString
 * Author:   Peter
 * Date:     02/05/2022 18:57
 * Description: https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=265&tqId=39255&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265&difficulty=undefined
 * &judgeStatus=undefined&tags=&title=
 * History:
 * Version:
 */
public class JZ58LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return "";
        }

        int length = str.length();
        // this is to tackle the problem that the n can be larger than the string length
        n = n % length;

        String sPre = str.substring(0, n);
        String sPost = str.substring(n, length);

        return sPost + sPre;
    }
}
