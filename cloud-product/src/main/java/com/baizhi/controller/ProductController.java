package com.baizhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * @Value("${server.port}") 读取application配置文件中的值
     * 赋值到成员变量上
     *
     * ${server.port} 参数为 application配置文件中的key
     */
    @Value("${server.port}")
    private String port;

    /**
     * @RequestParam 获取Request参数的 用于RestFul风格中
     * @PathVariable 获取路径中的参数
     */
    @GetMapping("showProductById")
    public String showProductById(@RequestParam("id") Integer id){
        return "查询到id为："+id+"的商品信息，使用端口号为："+port;
    }

    /**
     * 形参中需要添加注解 @RequestBody  获取请求体中的数据
     */
    @PostMapping("showProcuctByMapPost")
    public Map showProcuctByMapPost(@RequestBody Map map){
        map.put("product",2);
        return map;
    }


}
