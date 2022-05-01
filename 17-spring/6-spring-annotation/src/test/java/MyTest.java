import com.peter.config.MyConfig;
import com.peter.pojo.Dog;
import com.peter.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyTest
 * Author:   Peter
 * Date:     01/05/2022 19:37
 * Description:
 * History:
 * Version:
 */
public class MyTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testJavaConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Dog dog = applicationContext.getBean("dog", Dog.class);
        System.out.println(dog.name);
    }
}
