package com.cmb.dao;

import com.cmb.entity.Hero;
import org.apache.ibatis.annotations.Param;

public interface HeroDao {

    Hero findById(@Param("id") int id);

    /**
     * 新增或修改时
     */
    int save(Hero hero);

}
