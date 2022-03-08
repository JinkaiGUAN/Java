package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring01.service.AlphaService;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaController
 * Author:   Peter
 * Date:     08/03/2022 18:58
 * Description:
 * History:
 * Version:
 */

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

}
