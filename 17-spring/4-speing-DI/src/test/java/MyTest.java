import com.peter.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyTest
 * Author:   Peter
 * Date:     29/04/2022 08:51
 * Description:
 * History:
 * Version:
 */
public class MyTest {

    /**
     * 常量注入
     */
    @Test
    public void testConstantValueInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }

    /**
     * Bean 注入
     */
    @Test
    public void testBeanInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }

    /**
     * 数组 注入
     */
    @Test
    public void testArrayInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-array.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }

    /**
     * List 注入
     */
    @Test
    public void testListInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-list.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }

    /**
     * Map 注入
     */
    @Test
    public void testMapInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-map.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }

    /**
     * Set 注入
     */
    @Test
    public void testSetInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-set.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }

    /**
     * Null 注入
     */
    @Test
    public void testNullInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-null.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }

    /**
     * Properties 注入
     */
    @Test
    public void testPropertiesInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-properties.xml");
        Student student = (Student) applicationContext.getBean("Student");
        System.out.println(student);
    }
}
