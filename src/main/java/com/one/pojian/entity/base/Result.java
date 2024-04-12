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

    public static Result initResult(ResultCode resultCode) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setTimeStamp(System.currentTimeMillis());
        return result;
    }

    public static Result success() {
        Result result = Result.initResult(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = Result.initResult(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result result = Result.initResult(ResultCode.FAILURE);
        return result;
    }

    public static Result fail(ResultCode resultCode) {
        Result result = Result.initResult(resultCode);
        return result;
    }
}
