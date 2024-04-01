package com.one.pojian.controller;

import com.one.pojian.entity.po.LifeMH;
import com.one.pojian.mapper.LifeMHMapper;
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
public class LifeMHController {
    @Autowired
    private LifeMHMapper lifeMHMapper;

    @RequestMapping("/getLifeMHInfos")
    public List<LifeMH> getLifeMHInfos() {
        List<LifeMH> lifeMHs = lifeMHMapper.selectList(null);
        return lifeMHs;
    }
}
