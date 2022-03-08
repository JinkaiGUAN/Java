package spring01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring01.service.AlphaService;

import java.text.SimpleDateFormat;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaConfig
 * Author:   Peter
 * Date:     08/03/2022 18:34
 * Description:
 * History:
 * Version:
 */

@Configuration // 表示一个配置类 不是普通的类， @SpringBootApplication是用于程序入口的配置类
public class AlphaConfig {


    @Bean // 定义一个第三方的bean, 方法名就是bean的名字
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
    }



}
