package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring01.entity.User;
import spring01.service.UserService;
import spring01.util.CommunityConstant;

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
public class LoginController implements CommunityConstant {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/site/register";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "/site/login";
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

    // http://localhost:8080/community/activation/101/code
    @RequestMapping(path = "/activation/{userId}/{code}", method = RequestMethod.GET)
    public String activation(Model model, @PathVariable("userId") int userId, @PathVariable("code") String code) {
        int activationCode = userService.activation(userId, code);
        if (activationCode == ACTIVATION_SUCCESS) {
            model.addAttribute("msg", "The username is activated successfully, please log in!");
            model.addAttribute("target", "/login");
        } else if (activationCode == ACTIVATION_REPEAT) {
            model.addAttribute("msg", "Invalid operation! The account has been activated!");
            model.addAttribute("target", "/index");
        } else {
            model.addAttribute("msg", "Activation failure, the activation code provided is not correct!");
            model.addAttribute("target", "/index");
        }

        return "/site/operate-result";
    }


}
