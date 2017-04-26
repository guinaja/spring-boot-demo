package io.pivotal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All you need to run a Eureka registration server.
 *
 * @author Paul Chapman
 */
@Slf4j
@SpringBootApplication
@EnableEurekaServer
@RestController
public class BaseServicesApplication {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Tell server to look for registration.properties or registration.yml
        //System.setProperty("spring.config.name", "registration-server");

        SpringApplication.run(BaseServicesApplication.class, args);
        log.info("Eureka base server already started !!");
    }

    @Autowired
    DiscoveryClient client;

    @RequestMapping("/info")
    public String ServerInfo() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        return "client info : " + localInstance.getServiceId() + ":" + localInstance.getHost() + ":" + localInstance.getPort();
    }
}
