package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.Author;
import com.one.pojian.entity.po.Saying;
import org.apache.ibatis.annotations.MapKey;

import java.util.*;

public interface AuthorMapper extends BaseMapper<Author> {
    @MapKey("name")
    Map getAuthorMap();
    HashMap getAuthorHashMap();
    LinkedHashMap getAuthorLinkedHashMap();
    @MapKey("id")
    List<Map> getAuthorArrayListMap();
    @MapKey("id")
    LinkedList<Map> getAuthorLinkedListMap();
}
