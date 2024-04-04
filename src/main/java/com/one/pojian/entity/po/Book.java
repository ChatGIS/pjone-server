package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：ChatGIS
 * @date ：Created in 2024/4/2 9:00
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@TableName("book")
public class Book {
    private Long id;
    private String name;
    private String author;
}
