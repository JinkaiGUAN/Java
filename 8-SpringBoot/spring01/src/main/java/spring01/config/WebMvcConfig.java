package spring01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring01.annotation.LoginRequiredInterceptor;
import spring01.controller.interceptor.AlphaInterceptor;
import spring01.controller.interceptor.LoginTicketInterceptor;
import spring01.dao.LoginTicketMapper;

/**
 * Copyright (C), Peter GUAN
 * FileName: WebMvcConfig
 * Author:   Peter
 * Date:     15/03/2022 19:46
 * Description:
 * History:
 * Version:
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //@Autowired
    //private AlphaInterceptor alphaInterceptor;

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(alphaInterceptor)
        //        .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*/.jpeg")
        //        .addPathPatterns("/register", "/login");

        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*/.jpeg");

        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*/.jpeg"); // 静态资源不需要拦截，
        // 节省网络开销
    }




}
