package com.cmb.service.impl;

import com.cmb.dao.UserDao;
import com.cmb.entity.User;
import com.cmb.service.RoleService;
import com.cmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;


    @Override
    public void prtRole() {
        roleService.prtRole();
    }

    @Override
    public User queryUser(Integer id) {
        return null;
    }
}
