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
    private static final String PREFIX_USER_LIKE = "like:user";
    private static final String PREFIX_FOLLOWEE = "followee";
    private static final String PREFIX_FOLLOWER = "follower";
    private static final String PREFIX_KAPTCHA = "kaptcha";
    private static final String PREFIX_TICKET = "ticket";
    private static final String PREFIX_USER = "user";
    private static final String PREFIX_UV = "uv";
    private static final String PREFIX_DAV = "dav";
    private static final String PREFIX_POST = "post";

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

    /**
     * 某个用户的赞
     * like:user:userId
     * @param userId
     * @return
     */
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    /**
     * 某个用户关注的实体
     * followee:userId:entityType -> zset(entityId, now)
     * @param userId
     * @param entityType
     * @return
     */
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    /**
     * 某个实体拥有的粉丝
     * follower:entityType:entityId -> zset(userId, now)
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

    /**
     * 获取登录验证码
     * @param owner : 验证码的临时拥有者
     * @return
     */
    public static String getKaptchaKey(String owner) {
        return PREFIX_KAPTCHA + SPLIT + owner;
    }

    /**
     * 登录凭证
     * @return
     */
    public static String getTicketKey(String ticket) {
        return PREFIX_TICKET + SPLIT + ticket;
    }

    /**
     * 用户
     * @return
     */
    public static String getUserKey(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }

    /**
     * 单日独立访客 （UV）
     * @param date
     * @return
     */
    public static String getUVKey(String date) {
        return PREFIX_UV + SPLIT + date;
    }

    /**
     * 区间独立访客（UV）
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getUVKet(String startDate, String endDate) {
        return PREFIX_UV + SPLIT + startDate + SPLIT + endDate;
    }

    /**
     * 单日活跃用户 （DAU）
     * @param date
     * @return
     */
    public static String getDAUKey(String date) {
        return PREFIX_DAV + SPLIT + date;
    }

    /**
     * 区间活跃用户 （DAU）
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getDAUKey(String startDate, String endDate) {
        return PREFIX_DAV + SPLIT + startDate + SPLIT + endDate;
    }

    /**
     * 帖子分数
     * @return
     */
    public static String getPostScoreKey() {
        return PREFIX_POST + SPLIT + "score";
    }
}
