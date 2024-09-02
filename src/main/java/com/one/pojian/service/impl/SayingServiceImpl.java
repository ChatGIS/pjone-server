package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public int updateSaying(Saying saying) {
        return sayingMapper.updateById(saying);
    }

    @Override
    public int deleteSayingById(String id) {
        return sayingMapper.deleteById(id);
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
    @Override
    public IPage<Saying> getSayingPageList(HashMap params) {
        int current = (int) params.getOrDefault("current", 1);
        int size = (int) params.getOrDefault("size", 10);
        String name = (String) params.getOrDefault("name", "");
        String author = (String) params.getOrDefault("author", "");
        String book = (String) params.getOrDefault("book", "");
        String article = (String) params.getOrDefault("article", "");
        QueryWrapper<Saying> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        if(author != null && !author.trim().isEmpty()) {
            queryWrapper.like("author", author);
        }
        if(book != null && !book.trim().isEmpty()) {
            queryWrapper.like("book", book);
        }
        if(article != null && !article.trim().isEmpty()) {
            queryWrapper.like("article", article);
        }
        queryWrapper.orderByDesc("id");
        IPage<Saying> sayingIPage = new Page<>(current, size);
        return  sayingMapper.selectPage(sayingIPage, queryWrapper);
    }
}
