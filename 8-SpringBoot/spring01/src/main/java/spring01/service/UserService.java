package spring01.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import spring01.dao.UserMapper;
import spring01.entity.User;
import spring01.util.CommunityUtil;
import spring01.util.MailClient;

import javax.mail.event.MailEvent;
import java.util.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserService
 * Author:   Peter
 * Date:     09/03/2022 11:35
 * Description:
 * History:
 * Version:
 */

@Service
public class UserService {
    // 与user有关操作

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${community.path.domain}") // 因为不是bean
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public User findUserById(int id) {
        return userMapper.selectByID(id);
    }

    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();

        if (user == null) {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }

        // 次数不是代码逻辑出错 而是输入信息出错
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("usernameMsg", "Account cannot be null!");
            return map;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMsg", "Password cannot be null!");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("userEmailMsg", "Email cannot be null!");
            return map;
        }

        // 验证账号
        User usernameVerified = userMapper.selectByName(user.getUsername());
        if  (usernameVerified != null) {
            map.put("usernameMsg", "The inputted username already exists!");
            return map;
        }
        // 验证邮箱
        User userEmailVerified = userMapper.selectByEmail(user.getEmail());
        if (userEmailVerified != null) {
            map.put("userEmailMsg", "The email has been used before!");
            return map;
        }

        // 注册用户
        // 密码加密
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        user.setPassword(CommunityUtil.md5(user.getPassword() + user.getSalt()));
        // 设置 参数
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(CommunityUtil.generateUUID());
        user.setHeaderUrl(String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
        user.setCreateTime(new Date());
        userMapper.insertUser(user);  // 加入数据库之后就有ID

        // 发送激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail());
        // http://localhost:8080/community/activation/101/code
        String url = domain + contextPath + "/activation/" + user.getId() + "/" + user.getActivationCode();
        context.setVariable("url", url);

        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendEmail(user.getEmail(), "激活账号", content);

        return map;
    }
}

