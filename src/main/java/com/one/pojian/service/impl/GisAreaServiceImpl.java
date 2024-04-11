package com.one.pojian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.pojian.entity.po.GisArea;
import com.one.pojian.mapper.GisAreaMapper;
import com.one.pojian.service.GisAreaService;
import jakarta.annotation.Resource;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
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
    public List<Map> getChinaArea() throws ParseException {
        List<Map> listMap = new ArrayList<>();
        List<Map> res = gisAreaMapper.getChinaArea();
        for(int i = 0; i < res.size(); i++) {
            System.out.println("!!!!!!!!!!!!!" + res.get(i).get("name"));
            String geoOld = res.get(i).get("geo").toString();
            System.out.println(res.get(i).get("id"));
            // System.out.println(geoOld);
            String formattedPolygonString = formatPolygonString(geoOld);
            // isHaveSamePoint(geoOld);
            // String geoNew = removeSamePoint(geoOld);
            // System.out.println(geoNew);
            // calcPointCount("数据库", geoOld);
            String geoNew = queryGaodeApi(res.get(i).get("name").toString());
            // System.out.println(formattedPolygonString);
            // gisAreaMapper.updateGeoById(formattedPolygonString, res.get(i).get("id"));
            // String geoNew = "POLYGON((116.78302 37.245819,116.712982 37.148315,116.777527 37.059052,116.826965 37.041199,116.78302 37.245819))";
            gisAreaMapper.updateGeoById(geoNew, res.get(i).get("id"));
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

    private void isHaveSamePoint(String geoWKT) throws ParseException {
        // String wkt = "MULTIPOLYGON(((117.35 40.23, 117.89 40.23)))";
        WKTReader reader = new WKTReader();
        MultiPolygon multiPolygon = (MultiPolygon) reader.read(geoWKT);

        // 获取第一个多边形
        Polygon polygon = (Polygon) multiPolygon.getGeometryN(0);
        Coordinate[] coordinates = polygon.getCoordinates();

        // 检查是否有相同点
        for (int i = 0; i < coordinates.length - 1; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                if (coordinates[i].equals2D(coordinates[j])) {
                    if(i == 0 && j == coordinates.length - 1) {
                        // 面第一个点和最后一个点相同是正常的
                    } else {
                        System.out.println("相同点：" + coordinates[i].x + ", " + coordinates[i].y);
                    }
                }
            }
        }
    }

    private String removeSamePoint(String geoWKT) throws ParseException {
        StringBuilder multipolygonWKT = new StringBuilder("MULTIPOLYGON(((");
        // String wkt = "MULTIPOLYGON(((117.35 40.23, 117.89 40.23)))";
        WKTReader reader = new WKTReader();
        MultiPolygon multiPolygon = (MultiPolygon) reader.read(geoWKT);

        // 获取第一个多边形
        Polygon polygon = (Polygon) multiPolygon.getGeometryN(0);
        Coordinate[] coordinates = polygon.getCoordinates();


        // 检查是否有相同点
        for (int i = 0; i < coordinates.length - 1; i++) {
            Boolean isHaveSame = false;
            for (int j = i + 1; j < coordinates.length; j++) {
                if (coordinates[i].equals2D(coordinates[j])) {
                    if(i == 0 && j == coordinates.length - 1) {
                        // 面第一个点和最后一个点相同是正常的
                    } else {
                        // System.out.println("相同点：" + coordinates[i].x + ", " + coordinates[i].y);
                        isHaveSame = true;
                    }
                }
            }
            if(isHaveSame) {
                Double lon = Double.parseDouble(String.valueOf(coordinates[i].x) + i);
                Double lat = Double.parseDouble(String.valueOf(coordinates[i].y) + i);
                System.out.println(lon);
                System.out.println(lat);
                System.out.println(i + "iiiiiiiiiiiii");
                multipolygonWKT.append(lon).append(" ").append(lat);
            } else {
                multipolygonWKT.append(coordinates[i].x).append(" ").append(coordinates[i].y);
            }
            if (i < coordinates.length - 1) {
                multipolygonWKT.append(",");
            }
        }

        Double lastLon = coordinates[0].x;
        Double lastLat = coordinates[0].y;
        multipolygonWKT.append(lastLon + " "+ lastLat + ")))");
        return multipolygonWKT.toString();
    }

    private void calcPointCount(String sour, String geoWKT) throws ParseException {
        WKTReader reader = new WKTReader();
        MultiPolygon multiPolygon = (MultiPolygon) reader.read(geoWKT);

        // 计算点的个数
        int pointCount = 0;
        for (int i = 0; i < multiPolygon.getNumGeometries(); i++) {
            Polygon polygon = (Polygon) multiPolygon.getGeometryN(i);
            Coordinate[] coordinates = polygon.getCoordinates();
            pointCount += coordinates.length;
        }

        System.out.println(sour + "多边形内的点的个数：" + pointCount);
    }

    private String queryGaodeApi(String name) {
        String apiKey = "youapi"; // 替换为您的高德API Key
        String apiUrl = "https://restapi.amap.com/v3/config/district?key=" + apiKey + "&keywords="+name
                +"&subdistrict=1&extensions=all";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 解析JSON数据并提取各省的行政区划空间数据
            String jsonData = response.toString();

            String polyline = extractValue(jsonData, "polyline");
            // 在这里可以继续解析JSON数据并提取各省的行政区划空间数据
            // System.out.println(jsonData);
            String[] points = polyline.split(";");
            StringBuilder multipolygonWKT = new StringBuilder("MULTIPOLYGON(((");

            double firstLon = 0;
            double firstLat = 0;
            for (int i = 0; i < points.length; i++) {
                if(i == 0) {
                    String[] point = points[i].split(",");
                    firstLon = Double.parseDouble(point[0]);
                    firstLat = Double.parseDouble(point[1]);
                }
                double lon = 0;
                double lat = 0;
                if(points[i].contains("|")) {
                    continue;
                } else {
                    String[] point = points[i].split(",");
                    lon = Double.parseDouble(point[0]);
                    lat = Double.parseDouble(point[1]);
                }

                multipolygonWKT.append(lon).append(" ").append(lat);

                if (i < points.length - 1) {
                    multipolygonWKT.append(",");
                }
            }

            multipolygonWKT.append(","+firstLon + " " + firstLat + ")))");
            // System.out.println(multipolygonWKT.toString()); // 输出API响应的JSON数据

            // calcPointCount("高德api", multipolygonWKT.toString());

            connection.disconnect();
            return multipolygonWKT.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 使用正则表达式提取属性值的方法
    private static String extractValue(String input, String key) {
        String pattern = "\"" + key + "\":\\s*\"(.*?)\"";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }
}
