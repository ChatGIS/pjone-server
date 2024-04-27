package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.LifeColor;

import java.util.HashMap;
import java.util.List;

public interface LifeColorMapper extends BaseMapper<LifeColor> {
    List<HashMap> getMinuteLastYear();
}
