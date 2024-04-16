package com.one.pojian.entity.po;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @description：作者实体
 * @modified By：
 * @version: 1.0.0$
 */
@Data
public class Author {
    private BigInteger id;
    private String name;
    private String nationality;
    private Date birthday;
    private Date deathday;
}
