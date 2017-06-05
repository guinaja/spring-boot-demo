package com.example.receiver;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by prayoon-pc on 6/2/2017.
 */
@Slf4j
@Component
public class Listener {
    private CountDownLatch latch = new CountDownLatch(3);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(id = "receivePartitions0", topicPartitions =
            {@TopicPartition(topic = "${topic.demo}", partitions = {"0"})}, group = "${spring.kafka.consumer.group-id}")
    public void receivePartitions0(ConsumerRecord<?, ?> consumerRecord) {
        log.info("Partition [0] , offset [{}] , data='{}'",consumerRecord.offset(), consumerRecord.toString());
        latch.countDown();
    }

    @KafkaListener(id = "receivePartitions1", topicPartitions =
            {@TopicPartition(topic = "${topic.demo}", partitions = {"1"})}, group = "${spring.kafka.consumer.group-id}")
    public void receivePartitions1(ConsumerRecord<?, ?> consumerRecord) {
        log.info("Partition [1] , offset [{}] , data='{}'",consumerRecord.offset(), consumerRecord.toString());
        latch.countDown();
    }
}
