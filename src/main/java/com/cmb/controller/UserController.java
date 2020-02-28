package com.cmb.controller;

import com.cmb.entity.User;
import com.cmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userServiceImpl1;

    @Autowired
    private UserService userServiceImpl;


    @Autowired
    private UserService subUserServiceImpl;

    @RequestMapping(value = "sayHello",method = RequestMethod.GET )
    @ResponseBody
    public String sayHello(){
        System.out.println("Hello");
        userServiceImpl1.prtRole();
        return "dulv";
    }

    @RequestMapping(value = "queryUser",method = RequestMethod.GET)
    @ResponseBody
    public User queryUser(@RequestParam(value = "id") Integer id){
        User user = subUserServiceImpl.queryUser(id);

        return user;
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam(value="fileName") MultipartFile multipartFile) throws IOException {
        //处理逻辑
        String path = "F:/spring_ws/upload/" + multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File(path));
        return "success";
    }
}
