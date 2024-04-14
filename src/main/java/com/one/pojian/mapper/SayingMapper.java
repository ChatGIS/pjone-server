package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.Saying;

public interface SayingMapper extends BaseMapper<Saying> {
    Saying getRandomSaying();
}
