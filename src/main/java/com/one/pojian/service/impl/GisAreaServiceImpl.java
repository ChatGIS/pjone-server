package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.GisArea;
import com.one.pojian.mapper.GisAreaMapper;
import com.one.pojian.service.GisAreaService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description：行政区划
 */
@Service
public class GisAreaServiceImpl extends ServiceImpl<GisAreaMapper, GisArea> implements GisAreaService {

    @Resource
    private GisAreaMapper gisAreaMapper;

    @Override
    public List<Map> getChinaArea() {
        List<Map> listMap = new ArrayList<>();
        List<Map> res = gisAreaMapper.getChinaArea();
        for(int i = 0; i < res.size(); i++) {
            System.out.println("!!!!!!!!!!!!!" + res.get(i).get("name"));
            String geoOld = res.get(i).get("geo").toString();
            System.out.println(res.get(i).get("id"));
            // System.out.println(geoOld);
            String formattedPolygonString = formatPolygonString(geoOld);
            // System.out.println(formattedPolygonString);
            gisAreaMapper.updateGeoById(formattedPolygonString, res.get(i).get("id"));
        }
        return listMap;
    }

    private static String formatPolygonString(String polygonString) {
        // 定义一个正则表达式来匹配浮点数
        Pattern pattern = Pattern.compile("(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(polygonString);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            // 格式化匹配到的浮点数，保留六位小数
            String formattedNumber = String.format("%.6f", Double.parseDouble(matcher.group()));
            // 将格式化后的数字替换回原字符串
            matcher.appendReplacement(sb, formattedNumber);
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
