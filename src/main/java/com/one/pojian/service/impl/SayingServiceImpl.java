package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.base.ResultPage;
import com.one.pojian.entity.dto.SayingDTO;
import com.one.pojian.entity.po.RelSayingTag;
import com.one.pojian.entity.po.Saying;
import com.one.pojian.mapper.RelSayingTagMapper;
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
    @Resource
    private RelSayingTagMapper relSayingTagMapper;

    @Override
    public int addSaying(SayingDTO saying) {
        int num = sayingMapper.insert(saying);
        QueryWrapper queryWrapperDelete = new QueryWrapper();
        queryWrapperDelete.eq("saying_id", saying.getId());
        relSayingTagMapper.delete(queryWrapperDelete);
        String tagIds = saying.getTagIds();
        String[] tags = tagIds.split(",");
        for(String tagId : tags) {
            RelSayingTag relSayingTag = new RelSayingTag();
            relSayingTag.setSayingId(saying.getId());
            relSayingTag.setTagId(Integer.valueOf(tagId));
            relSayingTagMapper.insert(relSayingTag);
        }
        return num;
    }
    @Override
    public int updateSaying(SayingDTO saying) {
        int sNum = sayingMapper.updateById(saying);
        QueryWrapper queryWrapperDelete = new QueryWrapper();
        queryWrapperDelete.eq("saying_id", saying.getId());
        relSayingTagMapper.delete(queryWrapperDelete);
        String tagIds = saying.getTagIds();
        String[] tags = tagIds.split(",");
        for(String tagId : tags) {
            RelSayingTag relSayingTag = new RelSayingTag();
            relSayingTag.setSayingId(saying.getId());
            relSayingTag.setTagId(Integer.valueOf(tagId));
            relSayingTagMapper.insert(relSayingTag);
        }
        return sNum;
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
    public ResultPage<SayingDTO> getSayingPageList(HashMap params) {
        List<SayingDTO> sayingDTOList = new ArrayList<>();
        int current = (int) params.getOrDefault("current", 1);
        int size = (int) params.getOrDefault("size", 10);
        String name = (String) params.getOrDefault("name", "");
        String author = (String) params.getOrDefault("author", "");
        String book = (String) params.getOrDefault("book", "");
        String article = (String) params.getOrDefault("article", "");
        String tagIds = (String) params.getOrDefault("tagIds", "");
        List<Integer> listTagId = new ArrayList<>();
        if(!tagIds.isEmpty()) {
            String [] tagIdArray =tagIds.split(",");
            for (String part : tagIdArray) {
                listTagId.add(Integer.parseInt(part.trim()));
            }
        }
        Integer tagSize = listTagId.size();
        Integer startIndex = size * (current - 1);
        List<Integer> sayingIdList = sayingMapper.getSayingPageList(startIndex, size, author, book, article, listTagId, tagSize);
        Integer total = sayingMapper.getSayingTotal(author, book, article, listTagId, tagSize);
        for(Integer id : sayingIdList) {
            sayingDTOList.add(sayingMapper.getSayingTags(id));
        }
        return new ResultPage<SayingDTO>(sayingDTOList, total, size, current, 0);
    }
}
