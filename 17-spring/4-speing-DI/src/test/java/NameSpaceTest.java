import com.peter.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), Peter GUAN
 * FileName: NameSpaceTest
 * Author:   Peter
 * Date:     30/04/2022 08:28
 * Description:
 * History:
 * Version:
 */
public class NameSpaceTest {

    @Test
    public void testPName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-pnamespace.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testCName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-pnamespace.xml");
        User user = applicationContext.getBean("user2", User.class);
        System.out.println(user);
    }

}
