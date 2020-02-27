package com.cmb.dao;

import com.cmb.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User queryUser(@Param("id") Integer id);
}
