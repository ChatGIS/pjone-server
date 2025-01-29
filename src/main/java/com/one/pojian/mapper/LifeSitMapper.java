package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.LifeSit;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface LifeSitMapper extends BaseMapper<LifeSit> {
    @Select("SELECT a.date, COUNT(a.date) AS count  FROM (" +
            "SELECT DATE_FORMAT(ls.do_date, '%Y-%m-%d') AS date " +
            "FROM life_sit ls) a " +
            "GROUP BY a.date " +
            "ORDER BY a.date")
    List<HashMap> getCountEveryDay();
}
