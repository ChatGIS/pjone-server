package com.one.pojian.entity.po;

import lombok.Data;

@Data
public class ReqParamCountry {
    String name;
    String code;
    ReqParamProvince[] provinces;
}
