package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.LifeColor;
import com.one.pojian.entity.po.Saying;
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
    public IPage<LifeColor> getLifeColorList(HashMap params) {
        int current = (int) params.getOrDefault("current", 1);
        int size = (int) params.getOrDefault("size", 10);
        String type = (String) params.getOrDefault("type", "");
        QueryWrapper<LifeColor> queryWrapper = new QueryWrapper<>();
        if(type != null && !type.trim().isEmpty()) {
            queryWrapper.eq("type", type);
        }
        queryWrapper.orderByDesc("id");
        IPage<LifeColor> lifeColorIPage = new Page<>(current, size);
        return  lifeColorMapper.selectPage(lifeColorIPage, queryWrapper);
    }

    @Override
    public List<HashMap> getMinuteLastYear() {
        List<HashMap> list = lifeColorMapper.getMinuteLastYear();
        return list;
    }

    @Override
    public List<HashMap> getNumLastYear() {
        List<HashMap> list = lifeColorMapper.getNumLastYear();
        return list;
    }

    @Override
    public int addLifeColor(LifeColor lifeColor) {
        int num = lifeColorMapper.insert(lifeColor);
        return num;
    }
    @Override
    public List<List> listRecordNum(String type) {
        List records = new ArrayList<>();
        QueryWrapper<LifeColor> queryWrapper = new QueryWrapper<>();
        if (!type.startsWith("Y")) {
            queryWrapper.eq("type", type);
        } else {
            // queryWrapper.and(i -> i.ne("type", "R").ne("type", "G"));
            queryWrapper.likeRight("type", "Y");
        }
        queryWrapper.select("do_date", "Sum(minute) as totalMinute")
                .groupBy("do_date");
        // List<LifeColor> listRecords = lifeColorMapper.selectList(queryWrapper);
        List<Map<String, Object>> listRecords = lifeColorMapper.selectMaps(queryWrapper);
        for(Integer i = 0; i < listRecords.size(); i++) {
            List record = new ArrayList();
            record.add(listRecords.get(i).get("do_date"));
            record.add(listRecords.get(i).get("totalMinute"));
            records.add(record);
        }
        return records;
    }

    @Override
    public List<HashMap> getSleepPointGroupLastYear() {
        List<HashMap> list = lifeColorMapper.getSleepPointGroupLastYear();
        return list;
    }
    @Override
    public List<HashMap> getSleepLongGroupLastYear() {
        List<HashMap> list = lifeColorMapper.getSleepLongGroupLastYear();
        return list;
    }
}