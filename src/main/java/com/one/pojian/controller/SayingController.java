package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.Saying;
import com.one.pojian.service.SayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
