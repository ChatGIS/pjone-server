package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.GisArea;
import org.apache.ibatis.annotations.MapKey;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GisAreaMapper extends BaseMapper<GisArea> {
    List<HashMap> getProvince();
    List<HashMap> getCity(String code);
    List<HashMap> getRegion(String code);
    List<HashMap> getTown(String code);
    int addArea(GisArea gisArea);
    @MapKey("id")
    List<Map> getChinaArea();
    void updateGeoById(String geo, Object id);
}
