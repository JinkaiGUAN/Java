package spring01.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: Event
 * Author:   Peter
 * Date:     30/03/2022 18:14
 * Description: 事件
 * History:
 * Version:
 */
public class Event {

    // 时间主题
    private String topic;
    private int userId;  // 当前事件触发对象
    private int entityType;
    private int entityId;
    private int entityUserid;  // 事件的发帖人
    private Map<String, Object> data = new HashMap<>();  // 封装可能升级后的其他事件信息

    public String getTopic() {
        return topic;
    }

    public Event setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityUserid() {
        return entityUserid;
    }

    public Event setEntityUserid(int entityUserid) {
        this.entityUserid = entityUserid;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Event setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "topic='" + topic + '\'' +
                ", userId=" + userId +
                ", entityType=" + entityType +
                ", entityId=" + entityId +
                ", entityUserid=" + entityUserid +
                ", data=" + data +
                '}';
    }
}
