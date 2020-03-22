package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author luxiaoyang
 * @create 2020-03-20-10:55
 *
 * @EnableConfigServer 声明当前项目为配置中心服务端
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigAppRun {
    public static void main(String[] args) {
        SpringApplication.run(ConfigAppRun.class,args);
    }
}
