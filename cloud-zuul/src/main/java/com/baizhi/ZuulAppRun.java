package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @EnableZuulProxy 声明当前项目为网关服务
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulAppRun {
    public static void main(String[] args) {
        SpringApplication.run(ZuulAppRun.class,args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
