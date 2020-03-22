package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer 声明当前项目为Eureka server
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerRun {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerRun.class,args);
    }
}
