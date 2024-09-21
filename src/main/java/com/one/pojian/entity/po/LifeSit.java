package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("life_sit")
public class LifeSit {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String type;
    private LocalDateTime doDate;
}
