package com.one.pojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.GisArea;

import java.util.List;
import java.util.Map;

public interface GisAreaService extends IService<GisArea> {
    List<Map> getChinaArea();
}
