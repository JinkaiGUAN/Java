package spring01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring01.Spring01Application;
import spring01.util.SensitiveFilter;

/**
 * Copyright (C), Peter GUAN
 * FileName: SensitiveTests
 * Author:   Peter
 * Date:     16/03/2022 23:49
 * Description:
 * History:
 * Version:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Spring01Application.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "这里可以赌博， 可以嫖娼， 可以开票， LOL";
        System.out.println(sensitiveFilter.filter(text));

        // todo: try to filter the alpha symbol
        text = "这里可以☆赌☆博， 可以☆嫖娼， 可以L开L票L， LOL";
        System.out.println(sensitiveFilter.filter(text));
    }
}
