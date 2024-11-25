package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.dto.SayingDTO;
import com.one.pojian.entity.po.Music;
import com.one.pojian.mapper.MusicMapper;
import com.one.pojian.service.MusicService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements MusicService {
    @Resource
    private MusicMapper musicMapper;

    @Override
    public int updateMusic(Music music) {
        music.setModifyDate(LocalDateTime.now());
        int sNum = musicMapper.updateById(music);
        QueryWrapper queryWrapperDelete = new QueryWrapper();
        return sNum;
    }
    @Override
    public IPage<Music> getMusicPageList(HashMap params) {
        List<SayingDTO> sayingDTOList = new ArrayList<>();
        int current = (int) params.getOrDefault("current", 1);
        int size = (int) params.getOrDefault("size", 10);
        String name = (String) params.getOrDefault("name", "");
        String ci = (String) params.getOrDefault("ci", "");
        String qu = (String) params.getOrDefault("qu", "");
        String chang = (String) params.getOrDefault("chang", "");
        Integer startIndex = size * (current - 1);
        IPage<Music> page = new Page<>(current, size);
        QueryWrapper<Music> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        IPage<Music> musicIPage = musicMapper.selectPage(page, queryWrapper);
        return musicIPage;
    }
}
