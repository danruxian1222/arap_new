package com.cmb.service.impl;

import com.cmb.service.RoleService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private Map myMap;

    @Override
    public void prtRole() {
        System.out.println("prtRole");
    }

    @Override
    public void prtAopBefore() {
        System.out.println("before");
    }

    @Override
    public void prtAopAfter() {
        System.out.println("after");
    }



}
