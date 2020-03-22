package com.baizhi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置
 */
@Configuration
public class RestTemplateConfig {

    /**
     * @LoadBalanced 开启Ribbon负载均衡
     * Ribbon本身只是一个负载均衡的工具 通过Ribbon进行服务调用
     * 使用还是 RestTemplate
     * 原理是：
     * 1.订单服务 通过 RestTemplate 发送请求 调用商品服务的接口
     * 2.订单服务中的Ribbon 会拦截 RestTemplate的请求 进行负载均衡
     * 3.Ribbon负载均衡结束 再次发送请求
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //        超时设置
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }
}