import com.peter.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyTest
 * Author:   Peter
 * Date:     28/04/2022 19:26
 * Description:
 * History:
 * Version:
 */
public class MyTest {
    public static void main(String[] args) {
        // 获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 对象在spring中管理， 都一bean的形式存在
        Hello hello = (Hello) context.getBean("Hello");
        System.out.println(hello);
    }
}
