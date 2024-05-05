package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.GisArea;
import com.one.pojian.service.GisAreaService;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
     * 根据编码、层级、类型获取行政区划
     * @param code  父级编码
     * @param level  层级
     * @param type  类型
     * @return
     */
    @RequestMapping("/getAreaByLevelAndCode")
    public Result getAreaByLevelAndCode(String code, int level, String type) {
        List<HashMap> areaList = gisAreaService.getAreaByLevelAndCode(code, level, type);
        return Result.success(areaList);
    }
    /**
     * 爬取天地图的行政区划数据
     * @param type 1:行政区域名称等信息列表；2:行政区划空间数据
     * @return
     */
    @RequestMapping("crawlAreaOfTDT")
    public Result crawlAreaOfTDT(int type) {
        int num = gisAreaService.crawlAreaOfTDT(type);
        return Result.success(num);
    }
    @RequestMapping("/addArea")
    public Result addArea(@RequestBody GisArea gisArea) {
        int num = gisAreaService.addArea(gisArea);
        return Result.success(num);
    }
    @RequestMapping("getProvince")
    public Result getProvince(String type) {
        List<HashMap> gisAreaList = gisAreaService.getProvince(type);
        return Result.success(gisAreaList);
    }
    @RequestMapping("/getChinaArea")
    public List<Map> getChinaArea() throws ParseException {
        return gisAreaService.getChinaArea();
    }
}
