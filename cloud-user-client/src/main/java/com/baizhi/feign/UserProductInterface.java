package com.baizhi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author luxiaoyang
 * @create 2020-03-19-10:07
 *
 * 所谓的Feign接口  就是一个普普通通的Java接口interface
 * 但是普通的interface是没有发送HTTP请求的能力的
 * 只要在接口上 加上 Feign的注解 这个普通的Java接口就变成Feign接口
 * 就具备了发送Http请求的能力
 *
 * @FeignClient(value = "cloud-product") 通过该注解当前接口就具备了发送
 * HTTP请求的能力  就变成了一个Feign接口（伪HTTP客户端，看上去是个接口）
 *
 * @FeignClient 参数是要请求服务的服务名称
 *
 * fallback 参数为 类对象 什么类对象呢？
 * 断路器替代方案的类对象
 */

@FeignClient(value = "cloud-product",fallback = UserProductInterfaceImpl.class)
public interface UserProductInterface {
    /**
     * 接口中写服务调用
     * 要请求的商品服务的接口是
     * String showProductById(@RequestParam("id") Integer id)
     *
     * 通过在接口中定义方法可以实现服务调用
     * 语法：
     * 1. Feign接口中的每一个方法对应一个要请求的其他服务的接口
     *    getShowProductById ---》商品服务 showProductById
     * 2. 定义方法的返回值 和 被请求接口的返回值类型一样
     *      因为都是Json 所以也可以都用String接收 【通用的】
     *      如果被请求接口的返回值类型是Map 也可以用Map接收
     *      Feign会自动将Json序列化为对象
     *      同理：被请求接口返回值类型是User  也可以用User接收
     *
     * 3. Feign接口中的方法名 自定义 【没有任何要求】
     * 4. Feign接口方法的形参 和 被请求接口的一致
     * 5. 方法上需要添加@RequestMapping 参数为 被请求接口的路径
     *    路径需要写全 如果有项目路径+类上定义的路径+方法上定义的路径
     */

    @RequestMapping("product-server/product/showProductById")
    String getShowProductById(@RequestParam("id") Integer id);

    /**
     *
     * 传递对象参数 Feign默认发送的就是Post请求
     *
     * 所以在传递 对象参数的时候 最好使用 PostMapping
     */
    @PostMapping("product-server/product/showProcuctByMapPost")
    Map showProcuctByMapPost(Map map);
}
