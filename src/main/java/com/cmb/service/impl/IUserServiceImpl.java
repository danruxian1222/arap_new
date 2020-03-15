package com.cmb.service.impl;

import com.cmb.dao.UserDao;
import com.cmb.entity.User;
import com.cmb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("iuserService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByUserName(String userName) {
        return userDao.queryUser(1);
    }

    @Bean
    public Map myMap(){
        Map map = new HashMap();
        return map;
    }
}
