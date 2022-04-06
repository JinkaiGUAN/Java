package spring01.util;

/**
 * Copyright (C), Peter GUAN
 * FileName: CommunityConstant
 * Author:   Peter
 * Date:     13/03/2022 11:23
 * Description:
 * History:
 * Version:
 */
public interface CommunityConstant {

    int ACTIVATION_SUCCESS = 0; // 激活成功
    int ACTIVATION_REPEAT = 1;  // 重复激活
    int ACTIVATION_FAILURE = 2;  // 激活失败

    /**
     * 默认的超时时间， 默认为12小时
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /**
     * 记录密码状态下的登录凭证超市时间
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;

    /**
     * 实体类型： 帖子
     */
    int ENTITY_TYPE_POST = 1;

    /**
     * 实体类型： 评论
     */
    int ENTITY_TYPE_COMMENT = 2;

    /**
     * 实体类型： 人
     */
    int ENTITY_TYPE_USER = 3;

    /**
     * 消息未读
     */
    int MESSAGE_UNREAD = 0;

    /**
     * 消息已读
     */
    int MESSAGE_READ = 1;

    /**
     * 消息已删除。 本数据库支支持本人删除， 则对方的消息列表也会被删除。
     */
    int MESSAGE_DELETE = 2;


    /**
     * 主题： 评论
     */
    String TOPIC_COMMENT = "comment";

    /**
     * 主题： 点赞
     */
    String TOPIC_LIKE = "like";

    /**
     * 主题： 关注
     */
    String TOPIC_FOLLOW = "follow";

    /**
     * 系统用户iD
     */
    int  SYSTEM_USER_ID = 1;
}
