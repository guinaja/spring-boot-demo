package com.example.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

/**
 * Created by prayoon-pc on 6/2/2017v.
 */
@Component
@Slf4j
public class Sender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String data) {
        log.info("sending data='{}' to topic='{}'", data, topic);
        kafkaTemplate.send(topic,  System.currentTimeMillis() + topic , data );
    }
}
