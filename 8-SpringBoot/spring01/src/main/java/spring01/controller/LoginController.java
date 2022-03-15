package spring01.controller;

import com.google.code.kaptcha.Producer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import spring01.entity.User;
import spring01.service.UserService;
import spring01.util.CommunityConstant;
import spring01.util.CommunityUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
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

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private Producer kaptchaProducer;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/site/register";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "/site/login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, String code, boolean rememberMe, Model model,
                        HttpSession session, HttpServletResponse response){
        // 验证 验证码
        String kaptcha = (String) session.getAttribute("kaptcha");
        if (StringUtils.isBlank(kaptcha) || StringUtils.isBlank(code) || !code.equalsIgnoreCase(kaptcha)) {
            model.addAttribute("codeMsg", "Verified code is not correct!");
            return "/site/login";
        }

        // 检查账号
        int expiredSeconds = rememberMe ? REMEMBER_EXPIRED_SECONDS : DEFAULT_EXPIRED_SECONDS;
        Map<String, Object> map = userService.login(username, password, expiredSeconds);
        if (map.containsKey("ticket")) {
            Cookie cookies = new Cookie("ticket", map.get("ticket").toString());
            cookies.setPath(contextPath);
            cookies.setMaxAge(expiredSeconds);
            response.addCookie(cookies);
            return "redirect:/index";
        } else {
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            return "/site/login";
        }
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

    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    public  void getKaptcha(HttpServletResponse response, HttpSession session) {
        // response 返回响应
        String text = kaptchaProducer.createText();
        BufferedImage bufferedImage = kaptchaProducer.createImage(text);

        // 将验证码存入session
        session.setAttribute("kaptcha", text);
        // 将图片输出到浏览器
        response.setContentType("image/png");

        OutputStream os = null;
        try {
            os = response.getOutputStream();
            ImageIO.write(bufferedImage, "png", os);
        } catch (IOException e) {
            logger.error("响应验证失败" + e.getMessage());
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(@CookieValue("ticket") String ticket) {
        userService.logout(ticket);
        return "redirect:/login";
    }

    @RequestMapping(path = "/forget", method = RequestMethod.GET)
    public String getForgetPage() {
        return "/site/forget";
    }

    @RequestMapping(path = "/forget/code", method = RequestMethod.GET)
    @ResponseBody
    public String getForgetCode(String email, HttpSession session) {
        if (StringUtils.isBlank(email)) {
            return CommunityUtil.getJSONString(1, "Email address cannot be blank!");
        }

        // send the email
        String code = CommunityUtil.generateUUID().substring(0, 4);
        userService.sendVerifiedCode(email, code);

        //save the verify code
        session.setAttribute("verifyCode", code);

        return CommunityUtil.getJSONString(0);
    }

    @RequestMapping(path = "/forget/password", method = RequestMethod.POST)
    public String resetPassword(String email, String verifyCode, String password, Model model, HttpSession session) {
        String code = (String) session.getAttribute("verifyCode");
        if (StringUtils.isBlank(verifyCode) || StringUtils.isBlank(code) || !code.equalsIgnoreCase(verifyCode)) {
            model.addAttribute("codeMsg", "Wrong verified code!");
            return "/site/forget";
        }

        Map<String, Object> map = userService.resetPassword(email, password);
        if (map.containsKey("user")) {
            return "redirect:/login";
        } else {
            model.addAttribute("emailMsg", map.get("emailMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            return "/site/forget";
        }
    }

    /**
     * 忘记密码视图层
     * 验证成功  重定向到登录界面 否则停留在forget界面
     * @param email
     * @param verifiedCode
     * @param newPassword
     * @param session 只要用来存储验证码信息
     * @return
     */
    //@RequestMapping(path = "/forget", method = RequestMethod.POST)
    //public String forget(String email, String verifiedCode, String newPassword, HttpSession session) {
    //
    //
    //    //Map<String, Object> map = userService.forget(email);
    //    System.out.println(email);
    //
    //    // 发送验证码
    //    String trueVerifiedCode = (String) session.getAttribute("verifiedCode");
    //    userService.sendVerifiedCode(email, trueVerifiedCode);
    //
    //    return "/site/forget";
    //}
    //
    ///**
    // * 依然通过kpatcha获取验证码 并保存在服务器种
    // * @return
    // */
    //@RequestMapping(path = "/forget/verifiedCode", method = RequestMethod.GET)
    //public String getVerifiedCode(HttpSession session) {
    //    String text = kaptchaProducer.createText();
    //
    //    // 将验证码保存在session种
    //    session.setAttribute("verifiedCode", text);
    //
    //    return "site/forget";
    //}



}
