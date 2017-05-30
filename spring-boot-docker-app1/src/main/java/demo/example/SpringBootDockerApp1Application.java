package demo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"demo"})
public class SpringBootDockerApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerApp1Application.class, args);
    }
}
