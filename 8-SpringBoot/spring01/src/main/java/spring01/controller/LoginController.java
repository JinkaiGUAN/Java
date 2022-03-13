package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring01.entity.User;
import spring01.service.UserService;

import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: LoginController
 * Author:   Peter
 * Date:     12/03/2022 15:24
 * Description:
 * History:
 * Version:
 */

@Controller // 一般我们还要加上requestMapping注解 但是我们在此不加 而是调用方法
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/site/register";
    }

    // 浏览器像server请求
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(Model model, User user) {
        Map<String, Object> map = userService.register(user);

        if (map == null || map.isEmpty()) {
            model.addAttribute("msg", "Register successfully, the corresponding activated email has been sent please " +
                    "click it and log in!");
            model.addAttribute("target", "/index"); // 跳转到返回的页面
            return "/site/operate-result";
        } else {
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            model.addAttribute("userEmailMsg", map.get("userEmailMsg"));
            return "/site/register";
        }
    }

}
