package com.cmb.controller;

import com.cmb.entity.ResponseVO;
import com.cmb.entity.User;
import com.cmb.service.IUserService;
import com.cmb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.ldap.PagedResultsControl;
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

    @Autowired
    private IUserService iuserService;

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

    /**
     * 增加测试方法
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO<String> checkLogin(@RequestParam("userName") String userName,
                                         @RequestParam("password") String password) {
        ResponseVO<String> response = new ResponseVO<String>();
        response.setSuccess(true);
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

            Subject subject = SecurityUtils.getSubject();

            subject.login(token);
        }catch (Exception e) {
            response.setSuccess(false);
        }

        return response;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseVO<String> logout(){
        ResponseVO<String> response = new ResponseVO<String>();
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        return response;
    }

    @RequestMapping(value="/queryUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<User> queryUserInfo() {
        ResponseVO<User> response = new ResponseVO<User>();
        response.setSuccess(true);
        try {
            User user = iuserService.selectUserByUserName("dulv");
            response.setT(user);
        } catch (Exception e) {
            response.setSuccess(false);
        }

        return response;
    }
}
