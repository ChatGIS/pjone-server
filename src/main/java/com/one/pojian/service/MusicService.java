package com.one.pojian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.Music;

import java.util.HashMap;

public interface MusicService extends IService<Music> {
    int updateMusic(Music saying);
    IPage<Music> getMusicPageList(HashMap params);
}
