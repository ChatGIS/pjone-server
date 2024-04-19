package com.one.pojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.Saying;

import java.util.HashMap;
import java.util.List;

public interface SayingService extends IService<Saying> {
    Saying getRandomSaying();
    List<List<Object>> getCountEveryDay();
}
