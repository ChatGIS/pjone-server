package com.one.pojian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.one.pojian.entity.po.LifeColor;
import com.one.pojian.entity.po.LifeWeight;

import java.util.HashMap;
import java.util.List;

public interface LifeWeightService {
    List<LifeWeight> getWeight();
}
