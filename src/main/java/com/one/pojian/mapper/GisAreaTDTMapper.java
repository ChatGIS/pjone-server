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
    List<GisAreaTDT> getArea();
    List<HashMap> getProvince();
    List<HashMap> getCity(String code);
    List<HashMap> getRegion(String code);
    List<HashMap> getTown(String code);
    int updateGeoById(String code, String geo, BigDecimal lng, BigDecimal lat);
    int insertAreaInfo(String name, String code, String classcode,
                       String province_code, String province_name,
                       String city_code, String city_name);
}
