package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("rel_saying_tag")
@Data
public class RelSayingTag {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer sayingId;
    private Integer tagId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
