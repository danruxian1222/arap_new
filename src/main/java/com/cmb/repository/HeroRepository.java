package com.cmb.repository;

import com.cmb.entity.Hero;

public interface HeroRepository {

    Hero findById(int id);

    /**
     * 新增或修改时
     */
    Hero save(Hero hero);

}
