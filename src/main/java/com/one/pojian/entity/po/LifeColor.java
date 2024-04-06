package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @author ：ChatGIS
 * @date ：Created in 2024/4/2 1:47
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@TableName("life_color")
public class LifeColor {
    private Long id;
    private Integer num;
    private String type;
    private Integer minute;
    private Date doDate;
}
