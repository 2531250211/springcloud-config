package wjx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.swing.*;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication2.class,args);
    }
}
