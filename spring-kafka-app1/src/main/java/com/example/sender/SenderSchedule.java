package com.example.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by prayoon-pc on 6/2/2017.
 */
@Slf4j
@Component
public class SenderSchedule {

    @Autowired
    private Sender sender;

    @Value("${topic.demo}")
    private String TOPIC_NAME;

    @Scheduled(fixedRate = 1000)
    public void send2Partition0() {
        log.info("Send message2kafka [{}]", System.currentTimeMillis());
        sender.send(TOPIC_NAME, "0","Message for partition 0");
    }
    @Scheduled(fixedRate = 5000)
    public void send2Partition1() {
        log.info("Send message2kafka [{}]", System.currentTimeMillis());
        sender.send(TOPIC_NAME, "1","Message for partition 1");
    }
}
