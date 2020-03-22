package com.baizhi;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @EnableDiscoveryClient 声明当前项目为一个 Eureka客户端 可以被发现的客户端
 * @EnableEurekaClient 声明当前项目为一个 Eureka客户端
 *
 * 区别：
 * @EnableEurekaClient 只能向 Eureka 注册中心注册
 * @EnableDiscoveryClient 除了向 Eureka 注册中心注册 可以向其他的注册中心注册 zookeeper consul
 *
 * @EnableFeignClients 开启feign
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UserAppRun {
    public static void main(String[] args) {
        SpringApplication.run(UserAppRun.class,args);
    }

    /**
     * Feign可以**配置**的日志级别有以下四种
     *
     * - NONE  不记录任何日志
     * - BASIC 仅仅记录请求方法，url，响应状态代码及执行时间
     * - HEAdERS 记录Basic级别的基础上，记录请求和响应的header
     * - FULL 记录请求和响应的header，body和元数据
     */
    @Bean
    public Logger.Level feignConfiguration() {
        return Logger.Level.FULL;
    }
}
