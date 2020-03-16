package com.cmb.controller;

import com.cmb.annotation.LogInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("log")
public class LogController extends BaseController{

    @RequestMapping(value = "logInfo",method = RequestMethod.GET)
    @LogInfo(check = true,value = "测试注解")
    @ResponseBody
    public String logInfo(){
        System.out.println("--------------logInfo-------------");
        return "--------------logInfo-------------";
    }
}
