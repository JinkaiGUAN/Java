package spring01.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Copyright (C), Peter GUAN
 * FileName: CommunityUtil
 * Author:   Peter
 * Date:     13/03/2022 08:59
 * Description:
 * History:
 * Version:
 */
public class CommunityUtil {

    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", " ");
    }

    // MD5 加密
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }

        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
