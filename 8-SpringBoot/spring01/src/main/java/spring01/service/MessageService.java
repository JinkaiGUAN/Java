package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring01.dao.MessageMapper;
import spring01.entity.Message;

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
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

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
}
