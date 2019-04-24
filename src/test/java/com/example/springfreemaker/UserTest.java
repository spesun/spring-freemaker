package com.example.springfreemaker;

import com.alibaba.fastjson.JSON;
import com.example.springfreemaker.entity.User;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserTest {
    public String url = "http://localhost:8081/";
    public RestTemplate restTemplate = new RestTemplate();
    public String name = "测试";

    @Test
    public void save() {
        User user = new User();
        user.setName("11111111");
        user.setPassword("11111111");

        String str = restTemplate.postForObject(url + "/user/save", user, String.class);
        System.out.println(str);
    }

    @Test
    public void get() {

        User user= restTemplate.getForObject(url + "/user/get?id=" + 1,  User.class);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    //使用Example查询
    public void findOne() {
        User user= restTemplate.getForObject(url + "/user/findOne?id=" + 11,  User.class);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void findName() {
        List users = restTemplate.getForObject(url + "/user/findName?name=" + name,  List.class);
        System.out.println(JSON.toJSONString(users));

             users = restTemplate.getForObject(url + "/user/findNameNative?name=" + name,  List.class);
        System.out.println(JSON.toJSONString(users));

        //findByName只要有接口就行了，不需要自己实现
            users = restTemplate.getForObject(url + "/user/findByName?name=" + name,  List.class);
        System.out.println(JSON.toJSONString(users));
    }

}

