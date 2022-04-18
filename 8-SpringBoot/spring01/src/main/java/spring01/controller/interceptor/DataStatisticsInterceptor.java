package spring01.controller.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import spring01.entity.User;
import spring01.service.DataStatisticsService;
import spring01.util.HostHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (C), Peter GUAN
 * FileName: DataStatisticsInterceptor
 * Author:   Peter
 * Date:     04/04/2022 10:46
 * Description: 用来统计DAU， UV数量
 * History:
 * Version:
 * @author Peter
 */

@Component
public class DataStatisticsInterceptor implements HandlerInterceptor {

    @Autowired
    private DataStatisticsService dataStatisticsService;

    @Autowired
    private HostHolder hostHolder;

    /**
     * 在请求最初进行统计
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 统计UV
        String ip = request.getRemoteHost();
        dataStatisticsService.recordUV(ip);

        // 统计DAU
        User user = hostHolder.getUser();
        if (user != null) {
            dataStatisticsService.recordDAU(user.getId());
        }

        // 统计完数据为了让请求继续下去， 返回true
        return true;
    }
}
