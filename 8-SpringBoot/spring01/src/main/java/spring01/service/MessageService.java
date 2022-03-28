package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import spring01.dao.MessageMapper;
import spring01.entity.Message;
import spring01.util.CommunityConstant;
import spring01.util.SensitiveFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: MessageService
 * Author:   Peter
 * Date:     20/03/2022 20:16
 * Description:
 * History:
 * Version:
 */

@Service
public class MessageService implements CommunityConstant {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private SensitiveFilter sensitiveFilter;

    public List<Message> findConversations(int userId, int offset, int limit) {
        return messageMapper.selectConversations(userId, offset, limit);
    }

    public int findConversationCount(int userId) {
        return messageMapper.selectConversationCount(userId);
    }

    public List<Message> findLetters(String conversationId, int offset, int limit) {
        return messageMapper.selectLetters(conversationId, offset, limit);
    }

    public int findLettersCount(String conversationId) {
        return messageMapper.selectLettersCount(conversationId);
    }

    public int findLettersUnreadCount(int userId, String conversationId) {
        return messageMapper.selectLettersUnreadCount(userId, conversationId);
    }

    public int addMessage(Message message) {
        message.setContent(HtmlUtils.htmlEscape(message.getContent()));
        message.setContent(sensitiveFilter.filter(message.getContent()));

        return messageMapper.insertMessage(message);
    }

    /**
     * 已读多条消息
     * @param ids
     * @return
     */
    public int readMessage(List<Integer> ids) {
        return messageMapper.updateStatus(ids, MESSAGE_READ);
    }

    /**
     * 删除多条消息， 但是在调用的时候一般是一条。
     * @param id
     * @return
     */
    public int deleteMessage(int id) {
        return messageMapper.updateStatus(Arrays.asList(new Integer[]{id}), MESSAGE_DELETE);
    }

    /**
     * 根据id查询回话
     * @param id
     * @return
     */
    public Message findLetterById(int id) {
        return messageMapper.selectLetterById(id);
    }
}
