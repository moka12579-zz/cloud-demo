package com.baizhi.controller;

import com.baizhi.feign.UserProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luxiaoyang
 * @create 2020-03-19-10:21
 */
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * Feign接口和其他业务层方法接口Interface对比
     * - 定义方式有区别
     * - 使用方式没有任何区别
     */
    @Autowired
    private UserProductInterface userProductInterface;

    @RequestMapping("getShowUserProduct")
    public String getShowUserProduct(){
        /**
         * 直接通过Feign接口使用接口中的方法
         */
        String showProductById = userProductInterface.getShowProductById(1);
        return showProductById;
    }

    /**
     * 调用 Feign接口（Map参数）
     * @return
     */
    @RequestMapping("showProcuctByMapPost")
    public Map showProcuctByMapPost(){
        Map map = new HashMap();
        map.put("user",1);
        Map map1 = userProductInterface.showProcuctByMapPost(map);
        return map1;
    }


}
