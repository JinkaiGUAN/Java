import com.peter.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyTest
 * Author:   Peter
 * Date:     01/05/2022 12:29
 * Description:
 * History:
 * Version:
 */
public class MyTest {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans2.xml");
        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(person);
        person.getCat().bark();
        person.getDog().bark();
    }
}
