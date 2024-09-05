package com.one.pojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.SysTag;

import java.util.List;

public interface SysTagService extends IService<SysTag> {
    List<SysTag> getTag(String type, String name);
    int addTag(SysTag tag);
}
