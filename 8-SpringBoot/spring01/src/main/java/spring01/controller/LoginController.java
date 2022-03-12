package spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/site/register";
    }
}
