package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by prayoon-pc on 4/25/2017.
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CloudClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(CloudClientApplication.class, args);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(  @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }


    @RequestMapping("/info")
    public String ServerInfo() {
        ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
        return "client info : "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
    }

    @RequestMapping("/getTime")
    public String hello() {
        //Get current date time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return "Current Time : " + formatDateTime;
    }
}
