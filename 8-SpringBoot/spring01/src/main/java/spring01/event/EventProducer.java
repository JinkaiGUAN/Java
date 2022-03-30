package spring01.event;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import spring01.entity.Event;

/**
 * Copyright (C), Peter GUAN
 * FileName: EventProducer
 * Author:   Peter
 * Date:     30/03/2022 18:22
 * Description:
 * History:
 * Version:
 */

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // 处理事件
    public void fireEvent(Event event) {
        // 将时间发布到指定主题
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }
}
