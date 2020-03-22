package com.baizhi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查看订单信息  在方法中调用商品服务
     *
     * @HystrixCommand(fallbackMethod = "") 给方法添加断路器
     * 注解的参数为 替代方案的方法名字
     */
    @HystrixCommand(fallbackMethod = "testHystrix")
    @RequestMapping("showOrder")
    public String showOrder(){
        /**
         * 通过Ribbon 发送服务调用 用的是RestTemplate
         * RestTemplate 本身没有负载均衡的能力
         */
        String object = restTemplate.getForObject("http://cloud-product/product-server/product/showProductById?id=1", String.class);

        return "查询到订单数据，"+object;
    }

    public String testHystrix(){
        return "调用失败执行替代方案";
    }
}
