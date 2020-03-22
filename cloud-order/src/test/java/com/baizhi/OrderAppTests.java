package com.baizhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = {OrderAppRun.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderAppTests {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 测试get请求
     */
    @Test
    public void test1(){
        /**
         * getForObject  getForEntity
         * 参数1  url  必填项
         * 参数2 响应数据的类型 是String 还是 Map等 必填项
         * 参数3 请求携带参数 选填
         *
         * getForObject 方法的返回值就是 被调用接口响应的数据
         * getForEntity 方法的返回值是响应体对象 其中封装了响应数据 响应状态码等信息
         */
        String result = restTemplate.getForObject("http://localhost:8802/product-server/product/showProductById?id=1", String.class);

        System.out.println(result);

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8802/product-server/product/showProductById?id=1", String.class);

        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());

//        请求参数不拼接到url上
        /**
         * 通过map封装参数
         */
        Map map= new HashMap();
        map.put("id",1);

        String resultId = restTemplate.getForObject("http://localhost:8802/product-server/product/showProductById?id={id}", String.class,map);

        System.out.println(resultId);
    }

}
