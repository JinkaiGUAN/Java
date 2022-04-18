package main.com.peter.java.easy;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ5ReplaceWhiteSpace
 * Author:   Peter
 * Date:     10/04/2022 22:25
 * Description: https://www.nowcoder.com/practice/0e26e5551f2b489b9f58bc83aa4b6c68?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ5ReplaceWhiteSpace {

    public String replaceSpace (String s) {

        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(Character.toString(s.charAt(i)));
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        JZ5ReplaceWhiteSpace solution = new JZ5ReplaceWhiteSpace();

        String newStr = solution.replaceSpace("ahc adj ad");
        System.out.println(newStr);
    }
}
