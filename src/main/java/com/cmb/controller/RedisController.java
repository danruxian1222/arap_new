package com.cmb.controller;

import com.cmb.entity.ResponseVO;
import com.cmb.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "queryRedis",method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO queryRedis(){

        return redisService.queryRedis();
    }
}
