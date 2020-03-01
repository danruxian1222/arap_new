package com.cmb.service;

import com.cmb.entity.User;

public interface IUserService {
    User selectUserByUserName(String userName);
}
