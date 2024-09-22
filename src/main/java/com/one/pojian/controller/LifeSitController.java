package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.LifeSit;
import com.one.pojian.entity.po.LifeWeight;
import com.one.pojian.service.LifeSitService;
import com.one.pojian.service.LifeWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeSit")
public class LifeSitController {
    @Autowired
    private LifeSitService lifeSitService;

    @RequestMapping("/addSit")
    public Result getWeight(@RequestBody LifeSit lifeSit) {
        Integer num = lifeSitService.addSit(lifeSit);
        return  Result.success(num == 1);
    }
    @RequestMapping("/getSits")
    public Result getSits(@RequestBody LifeSit lifeSit) {
        List<LifeSit> sits = lifeSitService.getSits(lifeSit.getDoDate());
        return  Result.success(sits);
    }
}
