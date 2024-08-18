package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

/**
 * @description：语录实体
 * @modified By：
 * @version: 1.0.0$
 */
@Data
public class Saying {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String book;
    private String article;
    private Date createDate;
}
