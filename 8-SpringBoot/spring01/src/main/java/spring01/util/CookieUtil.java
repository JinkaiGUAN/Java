package spring01.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C), Peter GUAN
 * FileName: CookieUtil
 * Author:   Peter
 * Date:     15/03/2022 20:30
 * Description:
 * History:
 * Version:
 */
public class CookieUtil {
    /**
     * 得到当前请求的cookie
     * @param request： 请求体， cookie是存在request对象中
     * @param name： cookies的键
     * @return
     */
    public static String getValue(HttpServletRequest request, String name) {
        if (request == null || name == null) {
            throw new IllegalArgumentException("Input variables are blank!");
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}
