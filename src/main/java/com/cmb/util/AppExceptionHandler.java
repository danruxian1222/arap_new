package com.cmb.util;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    String handleException(){
        System.out.println("handleException=======");
        return "Exception Deal!";
    }
}
