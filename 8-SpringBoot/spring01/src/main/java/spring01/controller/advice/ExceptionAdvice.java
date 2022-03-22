package spring01.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spring01.util.CommunityUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Copyright (C), Peter GUAN
 * FileName: ExceptionAdvice
 * Author:   Peter
 * Date:     22/03/2022 08:54
 * Description:
 * History:
 * Version:
 */

@ControllerAdvice(annotations = Controller.class)
public class ExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        logger.error("服务器异常：" + e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            logger.error(element.toString());
        }
        // 判断请求是普通还是异步请求
        String xRequestedWith = request.getHeader("x-requested-with");
        if ("XMLHttpRequest".equals(xRequestedWith)) {
            // Json
            response.setContentType("application/plain;charset=utf-8");
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.write(CommunityUtil.getJSONString(1, "服务器异常"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect(request.getContextPath() + "/error");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
