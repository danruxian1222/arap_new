package com.cmb.service.impl;

import com.cmb.service.RoleService;
import com.cmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleService roleService;

    @Override
    public void prtRole() {
        roleService.prtRole();
    }
}
