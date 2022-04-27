package com.peter.util;

import java.util.UUID;

/**
 * Copyright (C), Peter GUAN
 * FileName: IdUtil
 * Author:   Peter
 * Date:     26/04/2022 20:32
 * Description:
 * History:
 * Version:
 */
public class IdUtil {
    public static String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
