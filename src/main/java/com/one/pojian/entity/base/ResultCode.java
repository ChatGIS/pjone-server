package com.one.pojian.entity.base;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("00000", "请求成功"),
    FAILURE("99999", "请求失败"),
    EMPTY_PARAM("A0410", "请求必填参数为空");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
