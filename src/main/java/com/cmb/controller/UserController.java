package com.cmb.controller;

import com.cmb.entity.ResponseVO;
import com.cmb.entity.User;
import com.cmb.service.IUserService;
import com.cmb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
                                         @RequestParam("password") String password,
                                         HttpServletRequest httpServletRequest) {
        ResponseVO<String> response = new ResponseVO<String>();
        response.setSuccess(true);
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

            Subject subject = SecurityUtils.getSubject();

            subject.login(token);

            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("USER_ID",userName);

        }catch (Exception e) {
            response.setSuccess(false);
        }

        return response;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
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

    @RequestMapping(value="/showUser",method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<User> showUser() {
        ResponseVO<User> response = new ResponseVO<User>();
        response.setSuccess(true);
        try {
            Subject subject = SecurityUtils.getSubject();
            System.out.println(subject.getPrincipal());

            //获取用户session(如果当前用户没有常见session的话,true则创建一个并返回,false为返回null)
            Session session = subject.getSession(true);
            //主机
            System.out.println("host:"+session.getHost());
            //session超时时间
            //session.setTimeout(15000);
            System.out.println("timeout:"+session.getTimeout());
            //属性参数值
            session.setAttribute("name", subject.getPrincipal());
            System.out.println("name:"+session.getAttribute("name"));
            session.removeAttribute("name");
            System.out.println("attributekeys:"+session.getAttributeKeys());
            //id
            System.out.println("id:"+session.getId());
            //访问时间(创建session的时间和最后访问session的时间)
            System.out.println("lastAccessTime:"+session.getLastAccessTime());
            session.touch();//更新会话访问时间
            System.out.println("StartTimestamp:"+session.getStartTimestamp());

            System.out.println("lastAccessTime:"+session.getLastAccessTime());
        } catch (Exception e) {
            response.setSuccess(false);
        }

        return response;
    }
}
