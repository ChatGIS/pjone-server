package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.GisArea;
import com.one.pojian.entity.po.GisAreaTDT;
import org.apache.ibatis.annotations.MapKey;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GisAreaTDTMapper extends BaseMapper<GisAreaTDT> {
    int updateGeoById(String code, String geo, BigDecimal lng, BigDecimal lat);
    List<GisAreaTDT> getArea();
    List<HashMap> getProvince();
}
