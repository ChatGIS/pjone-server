package com.one.pojian.entity.dto;

import com.one.pojian.entity.po.Saying;
import lombok.Data;

import java.util.List;

@Data
public class SayingDTO extends Saying {
    private String tagIds;
    private String tagNames;
}
