package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：ChatGIS
 * @date ：Created in 2024/4/7 10:44
 * @description：行政区划
 * @modified By：
 * @version: $
 */
@TableName(value = "gis_area")
@Data
public class GisArea {
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

    /**
     * 英文名称
     */
    private String engName;

    /**
     * 拼音名称
     */
    private String varName;

    /**
     * 英文类型名称
     */
    private String engTypename;

    /**
     * 空间坐标
     */
    private String geo;
}
