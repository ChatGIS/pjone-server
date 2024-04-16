package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.Author;
import com.one.pojian.entity.po.Saying;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface AuthorMapper extends BaseMapper<Author> {
    @MapKey("id")
    Map getAuthorMap();
    HashMap getAuthorHashMap();
    LinkedHashMap getAuthorLinkedHashMap();
}
