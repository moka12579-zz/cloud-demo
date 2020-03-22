package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author luxiaoyang
 * @create 2020-03-19-15:46
 */

@SpringBootApplication
@EnableHystrixDashboard
public class DashAppRun {

    public static void main(String[] args) {
        SpringApplication.run(DashAppRun.class,args);
    }
}
