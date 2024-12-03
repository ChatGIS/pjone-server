package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.LifeSit;
import com.one.pojian.entity.po.LifeUp;
import com.one.pojian.entity.po.LifeWeight;
import com.one.pojian.mapper.LifeSitMapper;
import com.one.pojian.mapper.LifeUpMapper;
import com.one.pojian.mapper.LifeWeightMapper;
import com.one.pojian.service.LifeSitService;
import com.one.pojian.service.LifeWeightService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LifeSitServiceImpl extends ServiceImpl<LifeSitMapper, LifeSit> implements LifeSitService {

    @Resource
    private LifeSitMapper lifeSitMapper;
    @Resource
    private LifeUpMapper lifeUpMapper;


    @Override
    public Integer addSit(LifeSit sit) {
        sit.setDoDate(LocalDateTime.now());
        return lifeSitMapper.insert(sit);
    }
    public List<LifeSit> getSits(LocalDateTime currentTime) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("do_date", currentTime.toLocalDate());
        return lifeSitMapper.selectList(queryWrapper);
    }
    public Integer addUp() {
        Integer updateNum = 0;
        QueryWrapper<LifeUp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("do_date", LocalDate.now());
        LifeUp lifeUp = lifeUpMapper.selectOne(queryWrapper);
        if(lifeUp == null) {
            LifeUp newLifeUp = new LifeUp();
            newLifeUp.setDoDate(LocalDate.now());
            newLifeUp.setNum(1);
            updateNum = lifeUpMapper.insert(newLifeUp);
        } else {
            lifeUp.setNum(lifeUp.getNum() + 1);
            updateNum = lifeUpMapper.updateById(lifeUp);
        }
        return updateNum;
    }
    public LifeUp getUp() {
        QueryWrapper<LifeUp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("do_date", LocalDate.now());
        LifeUp lifeUp = lifeUpMapper.selectOne(queryWrapper);
        return lifeUp;
    }
}