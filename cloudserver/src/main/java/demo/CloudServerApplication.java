package demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by prayoon-pc on 4/25/2017.
 */
@EnableEurekaServer
@SpringBootApplication
@RestController
public class CloudServerApplication {

    @Autowired
    DiscoveryClient client;

    public static void main(String[] args) {
        SpringApplication.run(CloudServerApplication.class, args);
    }

    @RequestMapping("/info")
    public String ServerInfo() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        return "client info : " + localInstance.getServiceId() + ":" + localInstance.getHost() + ":" + localInstance.getPort();
    }
}
