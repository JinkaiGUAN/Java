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
        User user = userService.findUserById(157);
        String newPassword = "12345";
        newPassword = CommunityUtil.md5(newPassword + user.getSalt());

        String passwordOnDb = "607336eeb312db9ff57f6ea2c4fea9ee";

        Assert.assertEquals(newPassword, passwordOnDb);

    }
}
