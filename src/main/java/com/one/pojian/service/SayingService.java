package com.one.pojian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.dto.SayingDTO;
import com.one.pojian.entity.po.Saying;

import java.util.HashMap;
import java.util.List;

public interface SayingService extends IService<Saying> {
    int addSaying(SayingDTO saying);
    int updateSaying(SayingDTO saying);
    int deleteSayingById(String id);
    Saying getRandomSaying();
    List<List<Object>> getCountEveryDay();
    IPage<Saying> getSayingPageList(HashMap params);
}
