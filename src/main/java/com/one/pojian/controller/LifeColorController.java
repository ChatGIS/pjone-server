package com.one.pojian.controller;

import com.one.pojian.entity.po.LifeColor;
import com.one.pojian.mapper.LifeColorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/lifeMH")
public class LifeColorController {
    @Autowired
    private LifeColorMapper lifeMHMapper;

    @RequestMapping("/getLifeMHInfos")
    public List<LifeColor> getLifeMHInfos() {
        List<LifeColor> lifeMHs = lifeMHMapper.selectList(null);
        return lifeMHs;
    }
}
