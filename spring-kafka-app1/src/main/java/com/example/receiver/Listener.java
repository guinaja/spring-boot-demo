package com.example.receiver;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by prayoon-pc on 6/2/2017.
 */
@Slf4j
@Component
public class Listener {
    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${topic.demo}" )
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("received data='{}'", consumerRecord.toString());
        latch.countDown();
    }
}
