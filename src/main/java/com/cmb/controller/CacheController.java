package com.cmb.controller;

import com.cmb.entity.Hero;
import com.cmb.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping("getValueByKey/{id}")
    @ResponseBody
    public Hero getValueByKey(@PathVariable("id") Integer key){

        return cacheService.getValueByKey(key);
    }

    @RequestMapping("save")
    @ResponseBody
    public Hero save(){

        return cacheService.save();
    }
}
