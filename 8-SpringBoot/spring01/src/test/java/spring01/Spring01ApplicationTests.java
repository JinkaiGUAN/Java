package spring01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import spring01.dao.AlphaDao;
import spring01.dao.AlphaDaoHibernateImpl;
import spring01.service.AlphaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = Spring01Application.class)
class Spring01ApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired // 依赖注入， 给当前的bean注入AlphaDao
    @Qualifier("alphaDaoHibernateImpl")  // 指定注入的bean
    private AlphaDao alphaDao;
    @Autowired
    private AlphaService alphaService;

//    @Test
//    void contextLoads() {
//
//
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext() {
        System.out.println(applicationContext);

        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());

        alphaDao = applicationContext.getBean("alphaDaoHibernateImpl", AlphaDao.class);
        System.out.println(alphaDao);
    }

    @Test
    public void testBeanManagement() {
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println("1 -- " + alphaService);

        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println("2 -- " + alphaService);
    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Test
    public void testDependencyInjection() {
        System.out.println(alphaDao);

        System.out.println(alphaService);
    }


}
