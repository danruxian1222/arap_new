package com.cmb.service.impl;

import com.cmb.dao.HeroDao;
import com.cmb.entity.Hero;
import com.cmb.entity.ResponseVO;
import com.cmb.repository.HeroRepository;
import com.cmb.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero getValueByKey(Integer key) {

        Hero h = heroRepository.findById(key);
        return h;
    }

    @Override
    public Hero save() {
        Hero h = new Hero();
        h.setName("李金玲");
        h.setAge(5);

        heroRepository.save(h);

        return h;
    }
}
