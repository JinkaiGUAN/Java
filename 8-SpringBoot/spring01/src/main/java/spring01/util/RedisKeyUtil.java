package spring01.util;

/**
 * Copyright (C), Peter GUAN
 * FileName: RedisKeyUtil
 * Author:   Peter
 * Date:     24/03/2022 17:37
 * Description:
 * History:
 * Version:
 */
public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";

    /**
     * 某个实体的赞
     * like:entity:entityTYpe:entityId -> set(userId)
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + entityId;
    }
}
