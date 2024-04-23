package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.LifeColor;
import com.one.pojian.service.LifeColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Result getLifeColorList() {
        List<LifeColor> lifeColorList = lifeColorService.getLifeColorList();
        return  Result.success(lifeColorList);
    }
    @RequestMapping("addLifeColor")
    public Result addLifeColor(@RequestBody LifeColor lifeColor) {
        int num = lifeColorService.addLifeColor(lifeColor);
        return Result.success(num);
    }
    @RequestMapping("/getRecordsNum")
    public Result getRecordsNum() {
        List<List> records = lifeColorService.listRecordNum();
        return Result.success(records);
    }
}
