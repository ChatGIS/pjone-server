package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.Saying;

import java.util.HashMap;
import java.util.List;

public interface SayingMapper extends BaseMapper<Saying> {
    Saying getRandomSaying();
    List<HashMap> getCountEveryDay();
}
