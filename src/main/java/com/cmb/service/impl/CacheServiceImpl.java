package com.cmb.service.impl;

import com.cmb.dao.HeroDao;
import com.cmb.entity.Hero;
import com.cmb.entity.ResponseVO;
import com.cmb.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private HeroDao heroDao;

    @Override
    public Hero getValueByKey(Integer key) {

        Hero h = heroDao.findById(key);
        return h;
    }

    @Override
    public Hero save() {
        Hero h = new Hero();
        h.setName("李金玲");
        h.setAge(5);

        int i = heroDao.save(h);

        System.out.println(i);

        return h;
    }
}
