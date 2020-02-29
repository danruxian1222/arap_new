package com.cmb.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    String handleException(){
        System.out.println("handleException=======");
        return "Exception Deal!";
    }
}
