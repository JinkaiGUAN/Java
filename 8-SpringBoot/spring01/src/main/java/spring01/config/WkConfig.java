package spring01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Copyright (C), Peter GUAN
 * FileName: WkConfig
 * Author:   Peter
 * Date:     05/04/2022 14:39
 * Description:
 * History:
 * Version:
 */

@Configuration
public class WkConfig {

    private static final Logger logger = LoggerFactory.getLogger(WkConfig.class);

    @Value("${wk.image.storage}")
    private String wkImageStorage;

    @PostConstruct
    public void init() {
        // 使用PostConstruct注解会让在Bean注入之后就会调用该函数进行初始化
        File file = new File(wkImageStorage);
        if (!file.exists()) {
            file.mkdir();
            logger.info("创建wk图片目录" + wkImageStorage);
        }
    }
}
