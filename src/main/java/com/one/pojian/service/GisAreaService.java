package com.one.pojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.GisArea;
import org.locationtech.jts.io.ParseException;

import java.util.List;
import java.util.Map;

public interface GisAreaService extends IService<GisArea> {
    int crawlAreaOfTDT();
    int addArea(GisArea gisArea);
    List<GisArea> getProvince();
    List<Map> getChinaArea() throws ParseException;
}
