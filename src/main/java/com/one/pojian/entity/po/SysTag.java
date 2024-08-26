package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_tag")
public class SysTag {
    private Long id;
    private String name;
    private Long orders;
    private String type;
}
