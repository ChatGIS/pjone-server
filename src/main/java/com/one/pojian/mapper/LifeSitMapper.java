package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.LifeSit;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface LifeSitMapper extends BaseMapper<LifeSit> {
    @Select("select lu.num as count,  lu.do_date as date from life_up lu order by do_date")
    List<HashMap> getCountEveryDayOfUp();
}
