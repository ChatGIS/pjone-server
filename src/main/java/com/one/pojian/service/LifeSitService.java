package com.one.pojian.service;

import com.one.pojian.entity.po.LifeSit;

import java.time.LocalDateTime;
import java.util.List;

public interface LifeSitService {
    Integer addSit(LifeSit lifeSit);
    List<LifeSit> getSits(LocalDateTime localDateTime);
}
