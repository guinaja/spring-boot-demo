package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan
public class SpringBootDockerApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApp2Application.class, args);
	}
}
