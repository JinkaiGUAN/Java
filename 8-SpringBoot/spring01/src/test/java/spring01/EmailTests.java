package spring01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import spring01.util.MailClient;

/**
 * Copyright (C), Peter GUAN
 * FileName: EmailTests
 * Author:   Peter
 * Date:     11/03/2022 09:39
 * Description:
 * History:
 * Version:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Spring01Application.class)
public class EmailTests {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine; // thymeleaf template engine

    @Test
    public void testSendEmail() {
        mailClient.sendEmail("crawlerforpeter@gmail.com", "Web server test", "Welcome");
    }

    @Test
    public void testHtmlEmail() {
        Context context = new Context();
        context.setVariable("username", "My baby");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        String to = "2225297210@qq.com";
        mailClient.sendEmail(to, "HTML test", content);
    }
}
