package com.cmb.service;

import com.cmb.entity.ResponseVO;

public interface RedisService {
    ResponseVO queryRedis();

    ResponseVO getValueByKey(String key);
}
