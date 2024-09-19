package com.one.pojian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.pojian.entity.dto.SayingDTO;
import com.one.pojian.entity.po.Saying;

import java.util.HashMap;
import java.util.List;

public interface SayingMapper extends BaseMapper<Saying> {
    Saying getRandomSaying();
    List<HashMap> getCountEveryDay();
    List<Integer> getSayingPageList(Integer startIndex, Integer size, String name, String author, String book,
                                      String article, List<Integer> tagIds, Integer tagSize);
    Integer getSayingTotal(String name, String author, String book,
                           String article, List<Integer> tagIds, Integer tagSize);
    SayingDTO getSayingTags(Integer id);
}
