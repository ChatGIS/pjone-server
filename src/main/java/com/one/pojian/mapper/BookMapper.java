package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.po.Book;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface BookMapper extends BaseMapper<Book> {
    @MapKey("id")
    List<Map> selectBook();
}
