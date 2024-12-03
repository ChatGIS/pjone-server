package com.one.pojian.service;

import com.one.pojian.entity.po.LifeSit;
import com.one.pojian.entity.po.LifeUp;

import java.time.LocalDateTime;
import java.util.List;

public interface LifeSitService {
    Integer addSit(LifeSit lifeSit);
    List<LifeSit> getSits(LocalDateTime localDateTime);
    Integer addUp();
    LifeUp getUp();
}
