package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Data
@TableName("life_weight")
public class LifeWeight {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Float weight;
    private LocalDate doDate;
}
