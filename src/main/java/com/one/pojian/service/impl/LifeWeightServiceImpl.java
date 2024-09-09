package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.LifeColor;
import com.one.pojian.entity.po.LifeWeight;
import com.one.pojian.mapper.LifeColorMapper;
import com.one.pojian.mapper.LifeWeightMapper;
import com.one.pojian.service.LifeColorService;
import com.one.pojian.service.LifeWeightService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LifeWeightServiceImpl extends ServiceImpl<LifeWeightMapper, LifeWeight> implements LifeWeightService {

    @Resource
    private LifeWeightMapper lifeWeightMapper;


    @Override
    public List<LifeWeight> getWeight() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("do_date");
        return lifeWeightMapper.selectList(queryWrapper);
    }
}