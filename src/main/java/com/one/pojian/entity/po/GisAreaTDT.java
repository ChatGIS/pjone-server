package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：ChatGIS
 * @date ：Created in 2024/4/7 10:44
 * @description：行政区划-天地图
 * @modified By：
 * @version: $
 */
@TableName(value = "gis_area_tdt")
@Data
public class GisAreaTDT {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 类型名称
     */
    private String typename;

    /**
     * 分类
     */
    private String classcode;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 区县编码
     */
    private String regionCode;

    /**
     * 区县名称
     */
    private String regionName;
    private BigDecimal lng;
    private BigDecimal lat;
    /**
     * 空间坐标
     */
    private String geo;
    private String remark;
}
