package com.cmb.service.impl;

import com.cmb.service.RoleService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public void prtRole() {
        System.out.println("admin");
    }

}
