package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.LifeWeight;
import com.one.pojian.service.LifeWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeWeight")
public class LifeWeightController {
    @Autowired
    private LifeWeightService lifeWeightService;

    @RequestMapping("/getWeight")
    public Result getWeight(@RequestBody LifeWeight lifeWeight) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
        List<LifeWeight> lifeColorList = lifeWeightService.getWeight();
        return  Result.success(lifeColorList);
    }
}
