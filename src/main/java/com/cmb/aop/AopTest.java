package com.cmb.aop;


import com.cmb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class AopTest {

    @Autowired
    private RoleService roleService;

    void sayAopTestBefore(){
        roleService.prtAopBefore();
    }

    void sayAopTestAfter(){
        roleService.prtAopAfter();
    }
}
