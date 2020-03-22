package com.baizhi.feign;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Feign接口的本地实现类
 * 如果Feign远程调用失败 不能调用远程服务的时候
 * 断路器生效 调用本地的替代方案【Feign接口的本地实现类】
 */
@Service
public class UserProductInterfaceImpl implements UserProductInterface {
    @Override
    public String getShowProductById(Integer id) {
        return "失败，执行替代方案";
    }

    @Override
    public Map showProcuctByMapPost(Map map) {
        map.put("失败","替代方案");
        return map;
    }
}
