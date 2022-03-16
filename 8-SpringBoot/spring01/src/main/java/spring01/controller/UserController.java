package spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserController
 * Author:   Peter
 * Date:     16/03/2022 08:29
 * Description: 用户界面
 * History:
 * Version:
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/setting", method = RequestMethod.GET)
    public String getSettingPage() {
        return "/site/setting";
    }


}
