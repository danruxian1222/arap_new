package com.cmb.repository;

import com.cmb.dao.HeroDao;
import com.cmb.entity.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HeroRepositoryImpl implements HeroRepository{

    @Autowired
    private HeroDao heroDao;

    @Override
    @Cacheable(value = "hero",key = "#root.caches[0].name +':' + #p0")
    public Hero findById(int id) {
        return heroDao.findById(id);
    }

    @Override
    @CachePut(value = "hero",key = "#root.caches[0].name +':' + #p0.id")
    public Hero save(Hero hero) {
        heroDao.save(hero);
        return hero;
    }
}
