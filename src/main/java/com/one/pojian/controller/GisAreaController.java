package com.one.pojian.controller;

import com.one.pojian.service.GisAreaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/getChinaArea")
    public List<Map> getChinaArea() {
        return gisAreaService.getChinaArea();
    }
}
