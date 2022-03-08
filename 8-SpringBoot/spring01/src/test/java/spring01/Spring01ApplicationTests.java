package spring01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import spring01.dao.AlphaDao;
import spring01.dao.AlphaDaoHibernateImpl;
import spring01.service.AlphaService;

@SpringBootTest
@ContextConfiguration(classes = Spring01Application.class)
class Spring01ApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

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


}
