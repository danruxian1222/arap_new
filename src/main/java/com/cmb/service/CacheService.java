package com.cmb.service;

import com.cmb.entity.Hero;

public interface CacheService {

    Hero getValueByKey(Integer key);

    Hero save();
}
