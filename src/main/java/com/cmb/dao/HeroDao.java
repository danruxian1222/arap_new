package com.cmb.dao;

import com.cmb.entity.Hero;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface HeroDao {

    @Cacheable(value = "hero",key = "'Hero:'+ #p0")
    Hero findById(@Param("id") int id);

    /**
     * 新增或修改时
     */
    @CachePut(value = "hero",key = "'Hero:'+#p0.id")
    int save(Hero hero);

}
