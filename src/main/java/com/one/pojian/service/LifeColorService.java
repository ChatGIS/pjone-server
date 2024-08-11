package com.one.pojian.service;

import com.one.pojian.entity.po.LifeColor;

import java.util.HashMap;
import java.util.List;

public interface LifeColorService {
    List<LifeColor> getLifeColorList();
    List<HashMap> getMinuteLastYear();
    List<HashMap> getNumLastYear();
    int addLifeColor(LifeColor lifeColor);
    List<List> listRecordNum(String type);
    List<HashMap> getSleepPointGroupLastYear();
    List<HashMap> getSleepLongGroupLastYear();
}
