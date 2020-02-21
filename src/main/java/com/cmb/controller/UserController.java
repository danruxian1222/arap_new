package com.cmb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "sayHello",method = RequestMethod.GET )
    @ResponseBody
    public String sayHello(){
        System.out.println("Hello");
        return "dulv";
    }
}
