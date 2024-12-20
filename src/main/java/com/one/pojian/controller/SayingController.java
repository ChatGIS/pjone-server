package com.one.pojian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.base.ResultPage;
import com.one.pojian.entity.dto.SayingDTO;
import com.one.pojian.entity.po.Saying;
import com.one.pojian.service.SayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @description：书籍
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/saying")
public class SayingController {
    @Autowired
    private SayingService sayingService;

    @RequestMapping("addSaying")
    public Result addSaying(@RequestBody SayingDTO saying) {
        int num = sayingService.addSaying(saying);
        return Result.success(num == 1);
    }
    @RequestMapping("updateSaying")
    public Result updateSaying(@RequestBody SayingDTO saying) {
        int num = sayingService.updateSaying(saying);
        return Result.success(num == 1);
    }
    @RequestMapping("/deleteSayingById")
    public Result deleteSayingById(String id) {
        int num = sayingService.deleteSayingById(id);
        return Result.success(num);
    }
    @RequestMapping("/getRandomSaying")
    public Result getRandomSaying() {
        Saying saying = sayingService.getRandomSaying();
        return Result.success(saying);
    }
    @RequestMapping("/getCountEveryDay")
    public Result getCountEveryDay() {
        List<List<Object>> lists = sayingService.getCountEveryDay();
        return Result.success(lists);
    }
    @RequestMapping("/getSayingPageList")
    public Result getSayingList(@RequestBody HashMap params) {
        ResultPage<SayingDTO> sayingPageResult = sayingService.getSayingPageList(params);
        return Result.success(sayingPageResult);
    }
}
