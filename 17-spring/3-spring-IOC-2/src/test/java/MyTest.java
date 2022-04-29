import com.peter.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyTest
 * Author:   Peter
 * Date:     29/04/2022 08:32
 * Description:
 * History:
 * Version:
 */
public class MyTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) applicationContext.getBean("User");
        System.out.println(user);

    }
}
