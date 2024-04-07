package com.one.pojian.entity.base;

import lombok.Data;

/**
 * @description：结果统一封装
 * @version: $
 */
@Data
public class Result {
    private String code;
    private String message;
    private Object data;
    private Long timeStamp;

    public Result() {}

    public static Result success() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setTimeStamp(System.currentTimeMillis());
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setTimeStamp(System.currentTimeMillis());
        result.setData(data);
        return result;
    }
}
