package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.GisArea;
import org.apache.ibatis.annotations.MapKey;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface GisAreaMapper extends BaseMapper<GisArea> {
    int addArea(GisArea gisArea);

    @MapKey("id")
    List<Map> getChinaArea();

    void updateGeoById(String geo, Object id);
}
