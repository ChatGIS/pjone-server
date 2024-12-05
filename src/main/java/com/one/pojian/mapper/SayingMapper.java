package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.dto.SayingDTO;
import com.one.pojian.entity.po.Saying;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface SayingMapper extends BaseMapper<Saying> {
    Saying getRandomSaying();
    List<HashMap> getCountEveryDay();
    List<Integer> getSayingPageList(@Param("startIndex") Integer startIndex, @Param("size") Integer size,
        @Param("name") String name, @Param("author") String author, @Param("book") String book,
        @Param("article") String article, @Param("tagIds") List<Integer> tagIds, @Param("tagSize") Integer tagSize);
    Integer getSayingTotal(@Param("name") String name, @Param("author") String author, @Param("book") String book,
        @Param("article") String article, @Param("tagIds") List<Integer> tagIds, @Param("tagSize") Integer tagSize);
    SayingDTO getSayingTags(@Param("id") Integer id);
}
