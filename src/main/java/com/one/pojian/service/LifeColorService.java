package com.one.pojian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.one.pojian.entity.po.LifeColor;

import java.util.HashMap;
import java.util.List;

public interface LifeColorService {
    IPage<LifeColor> getLifeColorList(HashMap params);
    List<HashMap> getMinuteLastYear();
    List<HashMap> getNumLastYear();
    int addLifeColor(LifeColor lifeColor);
    List<List> listRecordNum(String type);
    List<HashMap> getSleepPointGroupLastYear();
    List<HashMap> getSleepLongGroupLastYear();
}
