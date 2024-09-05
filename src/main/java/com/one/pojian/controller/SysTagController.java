package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.po.Saying;
import com.one.pojian.entity.po.SysTag;
import com.one.pojian.service.SysTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/systag")
public class SysTagController {
    @Autowired
    private SysTagService sysTagService;

    @RequestMapping("/getTag")
    public Result getTag(String type, String name) {
        List<SysTag> sysTagList = sysTagService.getTag(type, name);
        return Result.success(sysTagList);
    }
    @RequestMapping("/addTag")
    public Result addTag(@RequestBody SysTag tag) {
        return Result.success(sysTagService.addTag(tag));
    }
}
