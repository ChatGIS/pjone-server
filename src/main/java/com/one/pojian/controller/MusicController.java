package com.one.pojian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.base.ResultPage;
import com.one.pojian.entity.po.Music;
import com.one.pojian.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @description：音乐
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @RequestMapping("/getMusicPageList")
    public Result getMusicList(@RequestBody HashMap params) {
        IPage<Music> musicPageResult = musicService.getMusicPageList(params);
        return Result.success(musicPageResult);
    }

    @RequestMapping("updateMusic")
    public Result updateMusic(@RequestBody Music music) {
        int num = musicService.updateMusic(music);
        return Result.success(num == 1);
    }
}
