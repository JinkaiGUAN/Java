package spring01.dao;

import org.apache.ibatis.annotations.Mapper;
import spring01.entity.Message;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: MessageMapper
 * Author:   Peter
 * Date:     20/03/2022 09:44
 * Description:
 * History:
 * Version:
 */

@Mapper
public interface MessageMapper {

    /**
     * 查询当前用户的回话列表， 针对每个回话值返回一条最新消息
     *
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    List<Message> selectConversations(int userId, int offset, int limit);

    /**
     * 查询当前用户的回话数量
     * @param userId
     * @return
     */
    int selectConversationCount(int userId);

    /**
     *  查询某个回话所包含的私信列表
     *
     * @param conversationId
     * @param offset
     * @param limit
     * @return
     */
    List<Message> selectLetters(String conversationId, int offset, int limit);

    /**
     *  查询某个回话所包含的私信数量
     *
     * @param conversationId
     * @return
     */
    int selectLettersCount(String conversationId);

    /**
     *  查询未读私信的数量
     *
     * @param userId
     * @param conversationId
     * @return
     */
    int selectLettersUnreadCount(int userId, String conversationId);
}
