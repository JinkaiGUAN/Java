package spring01.event;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import spring01.entity.DiscussPost;
import spring01.entity.Event;
import spring01.entity.Message;
import spring01.service.DiscussPostService;
import spring01.service.ElasticsearchService;
import spring01.service.MessageService;
import spring01.util.CommunityConstant;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: EventConsumer
 * Author:   Peter
 * Date:     30/03/2022 18:26
 * Description: 出发是将， 向message表单中添加数据
 * History:
 * Version:
 * @author Peter
 */

@Component
public class EventConsumer implements CommunityConstant {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @Value("${wk.image.storage}")
    private String wkImageStorage;

    @Value("${wk.image.command}")
    private String wkImageCommand;

    @Autowired
    private MessageService messageService;

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private ElasticsearchService elasticsearchService;

    /**
     * x消息队列消费传入的点赞， 评论， 关注事件： 也即将这些事件的信息存入message表单中。
     * @param record
     */
    @KafkaListener(topics = {TOPIC_COMMENT, TOPIC_LIKE, TOPIC_FOLLOW})
    public void handleCommentMessage(ConsumerRecord record) {
        Event event = checkRecordStatus(record);
        if (event == null) {
            return;
        }

        // 发送站内通知
        Message  message = new Message();
        message.setFromId(SYSTEM_USER_ID);
        message.setToId(event.getEntityUserid());
        message.setConversationId(event.getTopic());
        message.setCreateTime(new Date());

        Map<String, Object> content = new HashMap<>();
        content.put("userId", event.getUserId());
        content.put("entityType", event.getEntityType());
        content.put("entityId", event.getEntityId());

        if (!event.getData().isEmpty()) {
            for(Map.Entry<String, Object> entry : event.getData().entrySet()) {
                content.put(entry.getKey(), entry.getValue());
            }
        }

        message.setContent(JSONObject.toJSONString(content));
        messageService.addMessage(message);
    }

    /**
     * 消费发帖事件
     * @param record
     */
    @KafkaListener(topics = {TOPIC_PUBLISH})
    public void handlePublishMessage(ConsumerRecord record) {
        Event event = checkRecordStatus(record);
        if (event == null) {
            return;
        }

        DiscussPost discussPost = discussPostService.findDiscussPostById(event.getEntityId());
        elasticsearchService.saveDiscussPost(discussPost);
    }

    /**
     * 消费删帖事件
     * @param record
     */
    @KafkaListener(topics = {TOPIC_DELETE})
    public void handleDeleteMessage(ConsumerRecord record) {
        Event event = checkRecordStatus(record);
        if (event == null) {
            return;
        }

        elasticsearchService.deleteDiscussPost(event.getEntityId());
    }

    /**
     * 消费分享事件
     * @param record
     */
    @KafkaListener(topics = {TOPIC_SHARE})
    public void handleShareMessage(ConsumerRecord record) {
        Event event = checkRecordStatus(record);
        if (event == null) {
            return;
        }

        String htmlUrl = (String) event.getData().get("htmlUrl");
        String filename = (String) event.getData().get("filename");
        String suffix = (String) event.getData().get("suffix");

        String cmd = wkImageCommand + " --quality 75 " + htmlUrl + " " + wkImageStorage + "/" + filename + suffix;
        try {
            Runtime.getRuntime().exec(cmd);
            logger.info("生成长图成功： " + cmd);
        } catch (IOException e) {
            logger.error("生成长图失败： " + e.getMessage());
        }
    }

    /**
     * 检查接收的record是否能返回真实的事件对象
     * @param record
     */
    private Event checkRecordStatus(ConsumerRecord record) {
        if (record == null || record.value() == null) {
            logger.error("消息内容为空");
            return null;
        }

        Event event = JSONObject.parseObject(record.value().toString(), Event.class);
        if (event == null) {
            logger.error("消息格式错误");
            return null;
        }

        return event;
    }
}
