package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.LifeColor;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface LifeColorMapper extends BaseMapper<LifeColor> {
    List<HashMap> getMinuteLastYear();
    List<HashMap> getNumLastYear();
    List<HashMap> getSleepPointGroup(@Param("num") Integer num);
    List<HashMap> getSleepLongGroup(@Param("num") Integer num);
}
