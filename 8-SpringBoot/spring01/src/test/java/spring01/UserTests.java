package spring01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring01.entity.User;
import spring01.service.UserService;
import spring01.util.CommunityUtil;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserTests
 * Author:   Peter
 * Date:     19/03/2022 12:30
 * Description:
 * History:
 * Version:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Spring01Application.class)
public class UserTests {

    @Autowired
    private UserService userService;

    @Test
    public void testModifyPassword() {
        User user = userService.findUserById(111);
        String newPassword = "aaa";
        newPassword = CommunityUtil.md5(newPassword + user.getSalt());

        String passwordOnDb = "b8ca3cbc6fd57c78736c66611a7e7044";

        Assert.assertEquals(newPassword, passwordOnDb);

    }
}
