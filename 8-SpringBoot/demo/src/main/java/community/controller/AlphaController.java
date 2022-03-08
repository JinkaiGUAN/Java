package community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaController
 * Author:   Peter
 * Date:     08/03/2022 17:36
 * Description:
 * History:
 * Version:
 */

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello world";
    }
}
