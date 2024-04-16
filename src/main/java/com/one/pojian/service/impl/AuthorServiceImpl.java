package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.Author;
import com.one.pojian.entity.po.Saying;
import com.one.pojian.mapper.AuthorMapper;
import com.one.pojian.mapper.SayingMapper;
import com.one.pojian.service.AuthorService;
import com.one.pojian.service.SayingService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description：语录实现类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {
    @Resource
    private AuthorMapper authorMapper;

    @Override
    public Map getAuthorMap() {
        Map author = authorMapper.getAuthorMap();
        return author;
    }
    @Override
    public HashMap getAuthorHashMap() {
        HashMap author = authorMapper.getAuthorHashMap();
        return author;
    }
    @Override
    public LinkedHashMap getAuthorLinkedHashMap() {
        LinkedHashMap author = authorMapper.getAuthorLinkedHashMap();
        return author;
    }
}
