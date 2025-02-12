package com.one.pojian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.LifeColor;
import com.one.pojian.service.LifeColorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：ChatGIS
 * @date ：Created in 2024/4/2 2:02
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/lifeColor")
public class LifeColorController {
    @Autowired
    private LifeColorService lifeColorService;

    @RequestMapping("/getLifeColorList")
    public Result getLifeColorList(@RequestBody HashMap params) {
        IPage<LifeColor> lifeColorList = lifeColorService.getLifeColorList(params);
        return  Result.success(lifeColorList);
    }
    @RequestMapping("/getMinuteLastYear")
    public Result getMinuteLastYear() {
        List<HashMap> list = lifeColorService.getMinuteLastYear();
        return Result.success(list);
    };
    @RequestMapping("/getNumLastYear")
    public Result getNumLastYear() {
        List<HashMap> list = lifeColorService.getNumLastYear();
        return Result.success(list);
    };
    @RequestMapping("addLifeColor")
    public Result addLifeColor(@RequestBody LifeColor lifeColor) {
        int num = lifeColorService.addLifeColor(lifeColor);
        return Result.success(num);
    }
    @RequestMapping("updateLifeColor")
    public Result updateLifeColor(@RequestBody LifeColor lifeColor) {
        int num = lifeColorService.updateLifeColor(lifeColor);
        return Result.success(num);
    }
    @RequestMapping("/getRecordsNum")
    public Result getRecordsNum(String type) {
        List<List> records = lifeColorService.listRecordNum(type);
        return Result.success(records);
    }
    @RequestMapping("getSleepPointGroup")
    public Result getSleepPointGroup(@RequestParam("num") Integer num) {
        List<HashMap> list = lifeColorService.getSleepPointGroup(num);
        return Result.success(list);
    };
    @RequestMapping("/getSleepLongGroup")
    public Result getSleepLongGroup(@RequestParam("num") Integer num, String unit) {
        List<HashMap> list = lifeColorService.getSleepLongGroup(num);
        return Result.success(list);
    };
}
