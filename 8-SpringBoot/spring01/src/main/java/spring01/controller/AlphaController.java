package spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring01.service.AlphaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println("method ---- " + request.getMethod());
        System.out.println("Servlet path ---- " + request.getServletPath()); // 请求路径
        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }
        System.out.println(request.getParameter("code")); // 拿到浏览器请求的参数

        // 返回相应数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write("<h1>NewCoder</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    // 两种传参的方式
    // Get request : 检测url为 /students?current=1&limit=20 的网页
    @RequestMapping(path="/students", method = RequestMethod.GET)
    @ResponseBody
    public String  getStudents(@RequestParam(name = "current", required = false, defaultValue = "1") int current,
                               @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        // 写的input variable必须于网页给定的参数一致
        System.out.println("current : " + current + " limit: " + limit);
        return "Students";
    }

    // /student/123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println("ID : " + id);
        return "A student";
    }

    // 浏览器向服务器提交数据 - POST 请求. Get 请求也可以获取参数 但是不安全 而且参数过多时 get 无法保存
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudentInfo(String name, int age) {
        // 只要参数与对应表单一致 那么就可以获取
        System.out.println("name: " + name + " age: " + age);
        return "Success";
    }




}