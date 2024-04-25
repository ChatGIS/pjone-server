package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.Saying;
import com.one.pojian.mapper.SayingMapper;
import com.one.pojian.service.SayingService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public int addSaying(Saying saying) {
        int num = sayingMapper.insert(saying);
        return num;
    }
    @Override
    public Saying getRandomSaying() {
        Saying saying = sayingMapper.getRandomSaying();
        return saying;
    }

    @Override
    public List<List<Object>> getCountEveryDay() {
        List<List<Object>> listList = new ArrayList<>();
        List<HashMap> listMap = sayingMapper.getCountEveryDay();
        for (HashMap<String, Object> map : listMap) {
            List<Object> values = new ArrayList<>();
            for (Object value : map.values()) {
                values.add(value);
            }
            listList.add(values);
        }

        return listList;
    }
}
