package com.one.pojian.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("music")
public class Music {
    private Long id;
    private String name;
    private String qu;
    private String ci;
    private String chang;
    private String src;
    private Integer num;
    private LocalDateTime modifyDate;
}
