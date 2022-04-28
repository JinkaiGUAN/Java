

# 1. Spring
## 1.1. 简介

需要使用的 jar 包：
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.1.20.RELEASE</version>
</dependency>

```
## 1.2. 优点

1. Spring 是一个开源的框架（容器）。
2. Spring 是一个轻量级， 非侵入式的框架。
3. 控制反转 （IOC）， 面向切面编程 （AOP）.
4. 支持事务的处理， 对框架整合支持。

Spring 是一个轻量级的控制反转和面向切面编程的框架。

## 1.3. 组成

![<img width=40 src="./asserts/1_spring_framework.png"/>](./asserts/1_spring_framework.png)

# 2. IOC 理论

```java
public class UserServiceImpl implements UserService {

    /**
     * 这种方式每次增加一种dao接口， 就必须改动代码， 耦合性很高.
     */
    //private UserDao userDao = new UserDaoImpl();
    private UserDao userDao = new UserDaoMySqlImpl();
    
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
```

我们这里采用依赖注入的方式， 级增加一个set方法接口， 让用户自己传入需要使用的Dao方式。
```java
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    /**
     * 使用set方法， 自定义传入Dao 种类
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
```

```java
public class IoCTest {

    /**
     * 原始获得用户的方式, 只能获取指定方式的Dao， 耦合性较高
     */
    @Test
    public void testOrigin() {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }

    @Test
    public void testUseSetMethod() {
        UserServiceImpl userService = new UserServiceImpl();
        // 使用MySQL
        userService.setUserDao(new UserDaoMySqlImpl());
        userService.getUser();

        // 使用Oracle
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }

}

```
**IoC是Spring框架的核心内容**，使用多种方式完美的实现了IoC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IoC。

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。

![img.png](asserts/2_IoC_flowchart.png)

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

**控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dep**endency Injection,DI）。