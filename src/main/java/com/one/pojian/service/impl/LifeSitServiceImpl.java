package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.LifeSit;
import com.one.pojian.entity.po.LifeWeight;
import com.one.pojian.mapper.LifeSitMapper;
import com.one.pojian.mapper.LifeWeightMapper;
import com.one.pojian.service.LifeSitService;
import com.one.pojian.service.LifeWeightService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LifeSitServiceImpl extends ServiceImpl<LifeSitMapper, LifeSit> implements LifeSitService {

    @Resource
    private LifeSitMapper lifeSitMapper;


    @Override
    public Integer addSit(LifeSit sit) {
        sit.setDoDate(LocalDateTime.now());
        return lifeSitMapper.insert(sit);
    }
}