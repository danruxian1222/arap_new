package com.cmb.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    JSONObject handleException(Exception e){
        System.out.println(e.getMessage());
        JSONObject jo = new JSONObject();
        jo.put("msg",e.getMessage());
        return jo;
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    JSONObject handleRuntimeException (Exception e){
        System.out.println(e.getMessage());
        JSONObject jo = new JSONObject();
        jo.put("msg",e.getMessage());
        jo.put("success",false);
        return jo;
    }
}
