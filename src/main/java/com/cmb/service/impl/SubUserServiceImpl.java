package com.cmb.service.impl;

import com.cmb.dao.UserDao;
import com.cmb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubUserServiceImpl extends UserServiceImpl {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUser(Integer id) {
        User user = userDao.queryUser(id);
        return user;
    }
}
