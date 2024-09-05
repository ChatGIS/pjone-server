package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.SysTag;
import com.one.pojian.mapper.SysTagMapper;
import com.one.pojian.service.SysTagService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTagServiceImpl extends ServiceImpl<SysTagMapper, SysTag> implements SysTagService {
    @Resource
    private SysTagMapper sysTagMapper;
    @Override
    public List<SysTag> getTag(String type, String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", type);
        queryWrapper.like("name", name);
        queryWrapper.orderByAsc("orders");
        return sysTagMapper.selectList(queryWrapper);
    }

    @Override
    public int addTag(SysTag tag) {
        System.out.println(tag.getName() + "aaaaaaaaaaaaaa");
        return sysTagMapper.insert(tag);
    }

}
