package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.LifeColor;
import com.one.pojian.mapper.LifeColorMapper;
import com.one.pojian.service.LifeColorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LifeColorServiceImpl extends ServiceImpl<LifeColorMapper, LifeColor> implements LifeColorService {

    @Resource
    private LifeColorMapper lifeColorMapper;

    @Override
    public List<LifeColor> getLifeColorList() {
        QueryWrapper<LifeColor> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 10");
        return list(queryWrapper);
    }
    @Override
    public int addLifeColor(LifeColor lifeColor) {
        int num = lifeColorMapper.insert(lifeColor);
        return num;
    }
    @Override
    public List<List> listRecordNum() {
        List records = new ArrayList<>();

        QueryWrapper<LifeColor> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("type", "S");

        List<LifeColor> listRecords = lifeColorMapper.selectList(queryWrapper);
        for(Integer i = 0; i < listRecords.size(); i++) {
            List record = new ArrayList();
            record.add(listRecords.get(i).getDoDate());
            record.add(listRecords.get(i).getNum());
            records.add(record);
        }
        return records;
    }
}