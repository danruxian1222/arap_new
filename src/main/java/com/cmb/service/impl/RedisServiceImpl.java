package com.cmb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cmb.entity.ResponseVO;
import com.cmb.entity.User;
import com.cmb.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResponseVO queryRedis() {

        redisTemplate.boundValueOps("str").set("string",1000, TimeUnit.SECONDS);
        Map m = new HashMap();
        m.put("dulv","杜律");
        m.put("ljl","李金玲");

        redisTemplate.boundHashOps("map").putAll(m);

        redisTemplate.boundListOps("list").leftPush("杜律");
        redisTemplate.boundSetOps("set").add("ljl");

        User u = new User();
        u.setUserName("中国人");
        u.setPassword("中@#￥*（）——+");
        redisTemplate.boundValueOps("user").set(JSONObject.toJSONString(u),1000, TimeUnit.SECONDS);

        System.out.println(redisTemplate.opsForValue().get("str"));
        System.out.println(redisTemplate.opsForHash().get("map","dulv"));
        System.out.println(redisTemplate.opsForList().range("list",0,10));

        System.out.println(redisTemplate.opsForSet().members("set"));

        JSONObject jsonObject = JSONObject.parseObject((String)redisTemplate.opsForValue().get("user"));

        System.out.println(jsonObject);

        return new ResponseVO();
    }
}
