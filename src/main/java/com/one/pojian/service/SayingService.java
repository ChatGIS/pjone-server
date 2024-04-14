package com.one.pojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.Saying;

public interface SayingService extends IService<Saying> {
    Saying getRandomSaying();
}
