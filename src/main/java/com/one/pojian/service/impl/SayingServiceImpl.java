package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.Saying;
import com.one.pojian.mapper.SayingMapper;
import com.one.pojian.service.SayingService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @description：语录实现类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class SayingServiceImpl extends ServiceImpl<SayingMapper, Saying> implements SayingService {
    @Resource
    private SayingMapper sayingMapper;

    @Override
    public Saying getRandomSaying() {
        Saying saying = sayingMapper.getRandomSaying();
        return saying;
    }
}
