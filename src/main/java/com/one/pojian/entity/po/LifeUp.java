package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("life_up")
public class LifeUp {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer num;
    private LocalDate doDate;
}
