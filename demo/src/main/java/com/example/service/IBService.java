package com.example.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class IBService<M extends BaseMapper<T>, T> extends ServiceImpl {

    public void log() {
        log.debug("IBService");
    }


}
