package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerAppRun2 {
    public static void main(String[] args) {
        SpringApplication.run(ServerAppRun2.class,args);
    }
}
