package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_tag")
public class SysTag {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Long orders;
    private String type;
}
