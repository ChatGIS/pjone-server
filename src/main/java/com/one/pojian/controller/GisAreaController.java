package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.GisArea;
import com.one.pojian.service.GisAreaService;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description：行政区划
 */
@RestController
@RequestMapping("/gisarea")
public class GisAreaController {

    @Autowired
    private GisAreaService gisAreaService;

    /**
     * 爬取天地图的行政区划数据
     * @return
     */
    @RequestMapping("crawlAreaOfTDT")
    public Result crawlAreaOfTDT() {
        int num = gisAreaService.crawlAreaOfTDT();
        return Result.success(num);
    }
    @RequestMapping("/addArea")
    public Result addArea(@RequestBody GisArea gisArea) {
        int num = gisAreaService.addArea(gisArea);
        return Result.success(num);
    }
    @RequestMapping("getProvince")
    public Result getProvince() {
        List<GisArea> gisAreaList = gisAreaService.getProvince();
        return Result.success(gisAreaList);
    }
    @RequestMapping("/getChinaArea")
    public List<Map> getChinaArea() throws ParseException {
        return gisAreaService.getChinaArea();
    }
}
