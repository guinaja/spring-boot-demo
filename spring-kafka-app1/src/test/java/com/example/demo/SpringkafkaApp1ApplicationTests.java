package com.example.demo;

import com.example.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringkafkaApp1ApplicationTests {

	@Value("${topic.demo}")
	private String TOPIC_NAME;
	@Autowired
	private Sender sender;
	@Test
	public void contextLoads() {
		sender.send(TOPIC_NAME, "Hello Spring Kafka!");
	}

}
