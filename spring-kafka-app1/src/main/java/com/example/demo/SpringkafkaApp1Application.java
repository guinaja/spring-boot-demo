package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ComponentScan("com")
@SpringBootApplication
public class SpringkafkaApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringkafkaApp1Application.class, args);
	}
}
