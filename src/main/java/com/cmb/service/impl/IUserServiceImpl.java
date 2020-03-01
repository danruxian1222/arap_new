package com.cmb.service.impl;

import com.cmb.dao.UserDao;
import com.cmb.entity.User;
import com.cmb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iuserService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByUserName(String userName) {
        return userDao.queryUser(1);
    }
}
