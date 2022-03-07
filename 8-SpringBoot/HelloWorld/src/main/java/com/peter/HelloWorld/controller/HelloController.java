package com.peter.HelloWorld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), Peter GUAN
 * FileName: HelloController
 * Author:   Peter
 * Date:     07/03/2022 08:27
 * Description:
 * History:
 * Version:
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

}
